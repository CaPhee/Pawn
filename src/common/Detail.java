package common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Detail {
	public static String encodeMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public static boolean checkDate(String date1, String date2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date day1 = sdf.parse(date1);
			Date day2 = sdf.parse(date2);
			if (day1.after(day2)) {
				return false;
			} else {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean nullValue(String s) {
		if (s == null || s.length() == 0)
			return true;
		return false;
	}

	public static boolean minLength(int length, String s) {
		if (s.length() < length)
			return true;
		return false;
	}

	public static boolean maxLength(int length, String s) {
		if (s.length() > length)
			return true;
		return false;
	}

	public static boolean isDigits(String str) {
		Pattern pattern = Pattern.compile("\\d*");
		Matcher matcher = pattern.matcher(str);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean notVaildNumber(String s) {
		if (nullValue(s))
			return true;
		String regex = "[0-9]{10,11}";
		if ((!s.matches(regex)))
			return true;
		return false;
	}

	public static boolean notVaildNumbercm(String cmnd) {
		// TODO Auto-generated method stub
		if (nullValue(cmnd))
			return true;
		String regex = "^([0-9]{9}|[0-9]{12})$";
		if (!cmnd.matches(regex)) return true;
		return false;

	}

	public static boolean notVaildQuatity(String s) {
		if (nullValue(s))
			return true;
		int i = Integer.parseInt(s);
		if (i <= 0)
			return true;
		else
			return false;
	}

	public static boolean notVaildMoney(String s) {
		if (nullValue(s))
			return true;
		double i = Double.parseDouble(s);
		if (i <= 0)
			return true;
		else
			return false;
	}
}
