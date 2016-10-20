/*
	Kiểm tra database có tồn tại trong csdl ko
	Nếu có thì xóa
	Nếu không thì tạo db mới
*/
use master
go
if exists(SELECT * FROM master.dbo.sysdatabases WHERE name = N'QuanLyCamDo')
begin
	drop database QuanLyCamDo
end
create database QuanLyCamDo
	
/* Tạo bảng */
go
use QuanLyCamDo
go
create table USERS(
	username varchar(50) primary key,
	password varchar(32)
)
go
create table NHANVIEN(
	MaNV varchar(10) primary key,
	TenNV	nvarchar(50),
	username varchar(50) foreign key references USERS(username)
)
go
create table KHACHHANG(
	MaKH varchar(10) primary key,
	TenKH	nvarchar(50),
	CMND	varchar(9),
	DiaChi	nvarchar(max),
	SoDT	varchar(10),
	TinhTrang	nvarchar(50)
)
go
create table LOAIDANHMUC(
	MaLoaiDM	varchar(10) primary key,
	TenLoaiDM	nvarchar(100)
)
go
create table DANHMUC(
	MaDM	varchar(10) primary key,
	TenDM	nvarchar(100),
	MaLoaiDM	varchar(10) foreign key references LOAIDANHMUC(MaLoaiDM)
)

go
create table LAISUAT(
	MaLS	varchar(10) primary key,
	TenLS	nvarchar(50),
	LaiSuat	decimal(18,0),
	LaiQuaHan	decimal(18,0)
)
create table PHIEUCAM(
	MaPhieuCam	varchar(10) primary key,
	NgayCam	date,
	NgayChuocDuKien date,
	MaNV	varchar(10) foreign key references NHANVIEN(MaNV),
	MaKH	varchar(10) foreign key references KHACHHANG(MaKH),
	TongTienCam	decimal(18,0)
)
go
create table PHIEUCHUOC(
	MaPhieuChuoc	varchar(10) primary key,
	MaKH	varchar(10) foreign key references KHACHHANG(MaKH),
	MaNV	varchar(10) foreign key references NHANVIEN(MaNV),
	NgayChuocThucTe	date,
	TongTienChuoc decimal(18,0),
	MaPhieuCam	varchar(10) foreign key references PHIEUCAM(MaPhieuCam)
)
go
create table CT_PHIEUCAM(
	MaPhieuCam varchar(10) foreign key references PHIEUCAM(MaPhieuCam),
	TenSP nvarchar(100),
	SoLuong	int,
	SoTienCam	decimal(18,0),
	MoTa nvarchar(max),
	HinhAnh	varchar(100),
	MaLS	varchar(10) foreign key references LAISUAT(MaLS)
)
go
create table CT_PHIEUCHUOC(
	MaPhieuChuoc	varchar(10) foreign key references PHIEUCHUOC(MaPhieuChuoc),
	TenSP varchar(50),
	SoLuong	int,
	SoTienChuoc	decimal(18,0),
	SoNgayQuaHan	int
)
go
create table SANPHAMQUAHAN(
	MaSP	int identity(1,1) primary key,
	TenSP	nvarchar(100),
	SoTienCam	decimal(18,0),
	MaDM	varchar(10) foreign key references DANHMUC(MaDM),
	NgayCam	date,
	MaKH	varchar(10),
	MaPhieuCam varchar(10) foreign key references PHIEUCAM(MaPhieuCam)
)
go
create table SANPHAM(
	MaSP	int identity(1,1) primary key,
	TenSP	nvarchar(100),
	SoLuong	int,
	SoTienCam	decimal(18,0),
	TinhTrang	nvarchar(50),
	MaDM	varchar(10) foreign key references DANHMUC(MaDM),
	MaPhieuCam	varchar(10) foreign key references PHIEUCAM(MaPhieuCam),
	MaPhieuChuoc	varchar(10) foreign key references PHIEUCHUOC(MaPhieuChuoc)
)

/*trigger kiểm tra ngày chuộc phải lớn hơn hoặc bằng ngày cầm khi thêm vào bảng PHIEUCAM */
go
IF EXISTS (SELECT 1 FROM sys.triggers 
           WHERE Name = 'trig_InsertPCA_checkDate')
DROP TRIGGER [dbo].[trig_InsertPCA_checkDate]
go
create trigger trig_InsertPCA_checkDate on PHIEUCAM
for insert
as
begin
	declare @pc_ngaycam date
	declare @pc_ngaychuoc	date
	declare @maphieucam	varchar(10)

	select @pc_ngaycam =i.NgayCam from inserted i
	select @pc_ngaychuoc =i.NgayChuocDuKien from inserted i
	select @maphieucam = i.MaPhieuCam from inserted i
	update PHIEUCAM set TongTienCam =0 where MaPhieuCam = @maphieucam
	if(@pc_ngaycam>@pc_ngaychuoc)
	begin
	print N'Error: Ngày chuộc phải lớn hơn hoặc bằng ngày cầm'
	rollback tran
	end
end

/*trigger kiểm tra ngày chuộc phải lớn hơn hoặc bằng ngày cầm khi thêm vào bảng PHIEUCHUOC*/
go
IF EXISTS (SELECT 1 FROM sys.triggers 
           WHERE Name = 'trig_InsertPCH_checkDate')
DROP TRIGGER [dbo].[trig_InsertPCH_checkDate]
go
create trigger trig_InsertPCH_checkDate on PHIEUCHUOC
for insert
as
begin
	declare @pc_ngaycam date
	declare @pch_ngaychuoc	date
	declare @maphieucam	varchar(10)
	declare @maphieuchuoc varchar(10)
	
	select @maphieuchuoc = i.MaPhieuChuoc from inserted i
	select @pch_ngaychuoc =i.NgayChuocThucTe from inserted i
	select @maphieucam = i.MaPhieuCam from inserted i
	select @pc_ngaycam = p.NgayCam from PHIEUCAM p inner join inserted i 
	on p.MaPhieuCam = i.MaPhieuCam
	update PHIEUCHUOC set TongTienChuoc =0 where MaPhieuChuoc = @maphieuchuoc
	if(@pc_ngaycam>@pch_ngaychuoc)
	begin
	print N'Error: Ngày chuộc phải lớn hơn hoặc bằng ngày cầm'
	rollback tran
	end
end

/*trigger khi thêm 1 sản phẩm mới vào bản CT_PHIEUCAM thì 
tạo 1 sản phẩm trong bảng SANPHAM với MaPhieuCam vừa thêm
update lại tổng tiền cầm
*/
go
IF EXISTS (SELECT 1 FROM sys.triggers 
           WHERE Name = 'trig_ctSanPhamCam')
DROP TRIGGER [dbo].[trig_ctSanPhamCam]
GO
create trigger trig_ctSanPhamCam on CT_PHIEUCAM
for insert
as
begin
	declare @madm	varchar(10)
	declare @tensp varchar(10)
	declare @soluongcam	int
	declare @sotiencam decimal(18,0)
	declare @maphieucam varchar(10)
	
	select @madm =  LEFT(i.TenSP,2) from inserted i
	select @sotiencam = i.SoTienCam from inserted i
	select @tensp =  SUBSTRING(i.TenSP,4,LEN(i.TenSP)) from inserted i
	select @soluongcam = i.SoLuong from inserted i
	select @maphieucam = i.MaPhieuCam from inserted i
	begin tran
		insert into SANPHAM(TenSP,SoLuong,SoTienCam,TinhTrang,MaDM,MaPhieuCam,MaPhieuChuoc) 
		values (@tensp,@soluongcam,@sotiencam,N'Đang cầm',@madm,@maphieucam,null)
		update PHIEUCAM set TongTienCam = TongTienCam+ (@sotiencam*@soluongcam) 
		where MaPhieuCam=@maphieucam
		if(@@ERROR <>0)
				rollback tran
			else
				commit tran
end


/*function tính số ngày quá hạn*/
go
IF OBJECT_ID (N'fnc_TinhSoNgayQuaHan', N'FN') IS NOT NULL  
    DROP FUNCTION fnc_TinhSoNgayQuaHan;  
GO 
create function fnc_TinhSoNgayQuaHan
(
	@NgayCam date,
	@NgayChuocDuKien date,
	@NgayChuocThucTe date
)
returns int
begin
	declare @SoNgayCamDuKien int
	declare @SoNgayCamThucTe	int
	declare @SoNgayQuaHan int

	set @SoNgayCamDuKien = DATEDIFF(day,@NgayCam,@NgayChuocDuKien)
	set @SoNgayCamThucTe = DATEDIFF(day,@NgayCam,@NgayChuocThucTe)
	set @SoNgayQuaHan = @SoNgayCamThucTe-@SoNgayCamDuKien
	if(@SoNgayQuaHan<=0)
	 set @SoNgayQuaHan = 0
	
	return @SoNgayQuaHan
end



/*function tính tiền chuộc */
go
IF OBJECT_ID (N'fnc_TinhTienChuoc', N'FN') IS NOT NULL  
    DROP FUNCTION fnc_TinhTienChuoc;  
GO  
create function fnc_TinhTienChuoc
(	@NgayCam date,
	@NgayChuocDuKien date,
	@NgayChuocThucTe date,
	@LaiSuat decimal(18,0),
	@LaiSuatQuaHan decimal(18,0)
)
returns decimal(18,0)
as
begin
	declare @SoNgayQuaHan int
	declare @SoNgayCamThucTe int
	declare @SoNgayCamDuKien int
	declare @SoTienChuoc decimal(18,0)

	select @SoNgayQuaHan = dbo.fnc_TinhSoNgayQuaHan(@NgayCam,@NgayChuocDuKien,@NgayChuocThucTe)
	set @SoNgayCamThucTe = DATEDIFF(day,@NgayCam,@NgayChuocThucTe)
	set @SoNgayCamDuKien = DATEDIFF(day,@NgayCam,@NgayChuocDuKien)

	select @SoNgayQuaHan = dbo.fnc_TinhSoNgayQuaHan(@NgayCam,@NgayChuocDuKien,@NgayChuocThucTe)
	/*Nếu trả trước hạn chuộc dự kiến thì tiền chuộc = lãi*số ngày cầm*/
	if(@SoNgayQuaHan<=0)
	begin
		set @SoTienChuoc = @LaiSuat * @SoNgayCamThucTe
	end
	else
	/*Ngược lại trả quá hạn thì tiền chuộc = lãi*số ngày cầm + lãi quá hạn* số ngày quá hạn */
	begin
		set @SoTienChuoc = @LaiSuat*@SoNgayCamDuKien + @LaiSuatQuaHan*@SoNgayQuaHan
	end
	return @SoTienChuoc
end

/**
	trigger khi thêm 1 sản phẩm mới vào bản CT_PHIEUCHUOC thì 
	update lại SoLuong sản phẩm cầm trong SANPHAM	
	thêm sản phẩm vừa chuộc vào bảng SANPHAM
	TÍNH SỐ TIỀN CHUỘC
	update lại TongTienChuoc trong PHIEUCHUOC
*/
go
IF EXISTS (SELECT 1 FROM sys.triggers 
           WHERE Name = 'trig_Insert_ctSanPhamChuoc')
DROP TRIGGER [dbo].[trig_Insert_ctSanPhamChuoc]
go
create trigger trig_Insert_ctSanPhamChuoc	on CT_PHIEUCHUOC
after insert
as
begin
	declare @maphieuchuoc varchar(10)
	declare @tensp varchar(50)
	declare @soluongchuoc int
	declare @sotienchuoc	decimal(18,0)
	declare @songayquahan int

	declare @madm varchar(10)	
	declare @maphieucam varchar(10)
	declare @soluongconlai int
	declare @sotiencam decimal(18,0)

	declare @NgayCam date
	declare @NgayChuocDuKien date
	declare @NgayChuocThucTe date
	declare @LaiSuat	decimal(18,0)
	declare @LaiQuaHan	decimal(18,0)
	
	select @sotiencam = ca.SoTienCam from inserted i inner join PHIEUCHUOC p 
	on i.MaPhieuChuoc = p.MaPhieuChuoc inner join CT_PHIEUCAM ca on p.MaPhieuCam = ca.MaPhieuCam

	select @madm =  LEFT(c.TenSP,2) from inserted i inner join PHIEUCHUOC pch on i.MaPhieuChuoc = pch.MaPhieuChuoc
		inner join CT_PHIEUCAM c on pch.MaPhieuCam = c.MaPhieuCam
		where c.TenSP = i.TenSP

	select @maphieuchuoc = i.MaPhieuChuoc,@soluongchuoc = i.SoLuong,@tensp = i.TenSP 
	from inserted i

	select @maphieucam = p.MaPhieuCam from inserted i inner join PHIEUCHUOC p on i.MaPhieuChuoc = p.MaPhieuChuoc	

	select @NgayCam = pca.NgayCam,@NgayChuocDuKien = pca.NgayChuocDuKien,@NgayChuocThucTe= pch.NgayChuocThucTe,@LaiSuat = l.LaiSuat,@LaiQuaHan= l.LaiQuaHan
	from  PHIEUCHUOC pch inner join PHIEUCAM pca on pch.MaPhieuCam =pca.MaPhieuCam inner join CT_PHIEUCAM c on pca.MaPhieuCam = c.MaPhieuCam inner join LAISUAT l on c.MaLS = l.MaLS
	where pca.MaPhieuCam = @maphieucam

	select @soluongconlai = s.SoLuong 
	from SANPHAM s 
	where s.MaPhieuCam = @maphieucam and s.TenSP=@tensp and s.MaPhieuChuoc is null

	select @sotienchuoc= @sotiencam + dbo.fnc_TinhTienChuoc(@NgayCam,@NgayChuocDuKien,@NgayChuocThucTe,@LaiSuat,@LaiQuaHan)
	select @songayquahan= dbo.fnc_TinhSoNgayQuaHan(@NgayCam,@NgayChuocDuKien,@NgayChuocThucTe)

	if(@soluongchuoc>ISNULL(@soluongconlai,0))
	begin
		rollback tran
		return;
	end
	update CT_PHIEUCHUOC set SoTienChuoc = @sotienchuoc,SoNgayQuaHan=@songayquahan where TenSP=@tensp and MaPhieuChuoc = @maphieuchuoc
	update SANPHAM set SoLuong = SoLuong- @soluongchuoc where MaPhieuCam = @maphieucam and TenSP = @tensp
	/*update SANPHAM set SoLuong = SoLuong - @soluongchuoc where TenSP=@tensp and MaPhieuCam = @maphieucam */
	update PHIEUCHUOC set TongTienChuoc = TongTienChuoc + @sotienchuoc where MaPhieuChuoc=@maphieuchuoc
	insert into SANPHAM(TenSP,SoLuong,TinhTrang,MaDM,MaPhieuCam,MaPhieuChuoc) values(@tensp,@soluongchuoc,N'Đã chuộc',@madm,@maphieucam,@maphieuchuoc)
	if(@@ERROR <>0)
			rollback tran
		else
			commit tran
end

/*
	trigger khi có update trong SANPHAM
	nếu sản phẩm nào có số lượng = 0 thì
	xóa khỏi bảng SANPHAM
*/
go
IF EXISTS (SELECT 1 FROM sys.triggers 
           WHERE Name = 'trig_xoaSPDaChuocHoanToan')
DROP TRIGGER [dbo].[trig_xoaSPDaChuocHoanToan]
go
create trigger trig_xoaSPDaChuocHoanToan
on SANPHAM
after update
as
begin
	if UPDATE(SoLuong)
	declare @masp varchar(10)
	declare @soluong int
	select @masp = i.MaSP from inserted i
	select @soluong = i.SoLuong from inserted i
		if(@soluong = 0)
		begin
			delete from SANPHAM where MaSP = @masp
		end
end

go
/*proc chuyển sản phẩm quá hạn sang bảng SANPHAMQUAHAN nếu số ngày quá hạn > 1/2 số ngày cầm dự kiến*/
IF OBJECT_ID (N'sp_SanPhamQuaHan', N'P') IS NOT NULL  
    DROP proc sp_SanPhamQuaHan;  
GO  
create proc sp_SanPhamQuaHan
(
	@MaSP int
)
as
begin
	declare @NgayCam date
	declare	@NgayChuocDuKien date
	declare @MaDm	varchar(10)
	declare @MaKH	varchar(10)
	declare @TenSP	nvarchar(100)
	declare @SoTienCam	decimal(18,0)
	declare @MaPhieuCam varchar(10)
	select  @MaPhieuCam=p.MaPhieuCam, @NgayCam=p.NgayCam,@NgayChuocDuKien=p.NgayChuocDuKien,
	 @MaKH = p.MaKH,@TenSP = s.TenSP,@SoTienCam = s.SoTienCam,@MaDm =s.MaDM
		from SANPHAM s inner join PHIEUCAM p on s.MaPhieuCam = p.MaPhieuCam 
		inner join CT_PHIEUCAM c on p.MaPhieuCam = c.MaPhieuCam
		 where s.MaSP = @MaSP and s.MaPhieuChuoc is null

	declare @ngayhientai date
	declare @SoNgayCamDuKien int	
	declare @SoNgayCamThucTe	int	
	declare @SoNgayQuaHan int

	set @ngayhientai = getdate()
	set @SoNgayCamDuKien = DATEDIFF(day,@NgayCam,@NgayChuocDuKien)
	set @SoNgayCamThucTe = DATEDIFF(day,@NgayCam,@ngayhientai)
	set @SoNgayQuaHan = @SoNgayCamThucTe - @SoNgayCamDuKien
	begin tran
		if(@SoNgayQuaHan>@SoNgayCamDuKien/2)
		begin
			delete from SANPHAM where MaSP= @MaSP
			insert into SANPHAMQUAHAN(TenSP,SoTienCam,MaDM,NgayCam,MaKH,MaPhieuCam) 
			values (@TenSP,@SoTienCam,@MaDm,@NgayCam,@MaKH,@MaPhieuCam)
		end
		if(@@ERROR <>0)
			rollback tran
		else
			commit tran
end


go
/*proc cập nhật bảng SANPHAM*/
IF OBJECT_ID (N'sp_UpdateSanPham', N'P') IS NOT NULL  
    DROP proc sp_UpdateSanPham;  
GO  
create proc sp_UpdateSanPham
as
begin
	delete from dbo.SANPHAM
	DBCC CHECKIDENT ('dbo.SANPHAM', RESEED, 0) /* cập nhật lại identity */

	/*update sản phẩm từ bảng CT_PHIEUCAM sang bảng SANPHAM*/
	declare tro cursor for(select c.MaPhieuCam,c.TenSP,c.SoLuong,c.SoTienCam from CT_PHIEUCAM c)
	open tro
	declare @madm	varchar(10)
	declare @tensp nvarchar(100)
	declare @soluongcam	int
	declare @sotiencam decimal(18,0)
	declare @maphieucam varchar(10)
	fetch next from tro
	into @maphieucam,@tensp,@soluongcam,@sotiencam
	while @@FETCH_STATUS = 0
	begin
		set @madm = LEFT(@tensp,2)
		set @tensp = SUBSTRING(@tensp,4,LEN(@tensp))		
		insert into SANPHAM(TenSP,SoLuong,SoTienCam,TinhTrang,MaDM,MaPhieuCam,MaPhieuChuoc) 
		values (@tensp,@soluongcam,@sotiencam,N'Đang cầm',@madm,@maphieucam,null)

		fetch next from tro
		into @maphieucam,@tensp,@soluongcam,@sotiencam
	end
	if(@@ERROR <>0 )
	begin
		print 'ERROR '
		rollback tran
		return;
	end
	close tro
	deallocate tro

	/*update sản phẩm từ bảng CT_PHIEUCHUOC sang bảng SANPHAM*/
	declare tro cursor for(select ch.MaPhieuChuoc,ca.TenSP,ch.SoLuong,ca.SoTienCam,p.MaPhieuCam 
	from CT_PHIEUCHUOC ch inner join PHIEUCHUOC p on ch.MaPhieuChuoc = p.MaPhieuChuoc
	inner join CT_PHIEUCAM ca on p.MaPhieuCam=ca.MaPhieuCam )
	open tro
	declare @maphieuchuoc varchar(10)
	declare @soluongchuoc int
	declare @sotienchuoc	decimal(18,0)
	fetch next from tro
	into @maphieuchuoc,@tensp,@soluongchuoc,@sotiencam,@maphieucam
	while @@FETCH_STATUS = 0
	begin
		set @madm = LEFT(@tensp,2)
		set @tensp = SUBSTRING(@tensp,4,LEN(@tensp))
		insert into SANPHAM(TenSP,SoLuong,TinhTrang,MaDM,MaPhieuCam,MaPhieuChuoc) values(@tensp,@soluongchuoc,N'Đã chuộc',@madm,@maphieucam,@maphieuchuoc)
		
		fetch next from tro
		into @maphieuchuoc,@tensp,@soluongchuoc,@sotiencam,@maphieucam
	end
	if(@@ERROR <>0 )
	begin
		print ' ERROR '
		rollback tran
		return;
	end
	close tro
	deallocate tro

	/*kiểm tra những sản phẩm quá hạn và chuyển sang SANPHAMQUAHAN*/
	delete from SANPHAMQUAHAN
	DBCC CHECKIDENT ('dbo.SANPHAMQUAHAN', RESEED, 0) /* cập nhật lại identity */
	
	declare tro cursor for(select MaSP from SANPHAM)
	open tro
	declare @masp int
	fetch next from tro
	into @masp
	while @@FETCH_STATUS = 0
	begin
		exec sp_SanPhamQuaHan @MaSP=@masp

		fetch next from tro
		into @masp
	end
	if(@@ERROR <>0 )
	begin
		print ' ERROR '
		rollback tran
		return;
	end
	close tro
	deallocate tro
end
	


/* test */


/*thống kê theo sp đã chuộc*/
SELECT distinct s.TenSP,c.MaNV,c.NgayCam,s.TinhTrang,pch.SoTienChuoc as TienLai
from SANPHAM s FULL OUTER JOIN PHIEUCAM c on s.MaPhieuCam = c.MaPhieuCam
 FULL OUTER JOIN CT_PHIEUCAM pc 
on pc.MaPhieuCam = c.MaPhieuCam FULL OUTER JOIN PHIEUCHUOC ch on c.MaPhieuCam = ch.MaPhieuCam 
FULL OUTER JOIN CT_PHIEUCHUOC pch on pch.MaPhieuChuoc = ch.MaPhieuChuoc
where s.TinhTrang=N'Đã chuộc' and c.NgayCam between '2016-01-1' and '2016-12-1'

/*thống kê theo không chuộc*/
SELECT distinct s.TenSP,c.MaNV,c.NgayCam,N'Quá hạn' as TinhTrang,ISNULL(pch.SoTienChuoc,0)  as TienLai
from SANPHAMQUAHAN s FULL OUTER JOIN PHIEUCAM c on s.MaPhieuCam = c.MaPhieuCam FULL OUTER JOIN CT_PHIEUCAM pc
on pc.MaPhieuCam = c.MaPhieuCam FULL OUTER JOIN PHIEUCHUOC ch on c.MaPhieuCam = ch.MaPhieuCam 
FULL OUTER JOIN CT_PHIEUCHUOC pch on pch.MaPhieuChuoc = ch.MaPhieuChuoc
where s.MaSP is not null and c.NgayCam between '2016-01-1' and '2016-12-1'

/*thống kê theo tiền lãi */
SELECT distinct s.TenSP,c.MaNV,c.NgayCam,s.TinhTrang,
(ISNULL(pch.SoTienChuoc,pc.SoTienCam)-pc.SoTienCam) as TienLai
from SANPHAM s FULL OUTER JOIN PHIEUCAM c on s.MaPhieuCam = c.MaPhieuCam
FULL OUTER JOIN CT_PHIEUCAM pc 
on pc.MaPhieuCam = c.MaPhieuCam FULL OUTER JOIN PHIEUCHUOC ch on c.MaPhieuCam = ch.MaPhieuCam 
FULL OUTER JOIN CT_PHIEUCHUOC pch on pch.MaPhieuChuoc = ch.MaPhieuChuoc
where c.NgayCam between '2016-01-1' and '2016-12-1' and s.TenSP is not null

select ca.SoLuong from CT_PHIEUCAM ca inner join PHIEUCHUOC pch
on ca.MaPhieuCam =pch.MaPhieuCam 
where MaPhieuChuoc = 'PCH03'

