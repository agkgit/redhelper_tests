package com.redhelper;

import java.util.Arrays;
import java.util.List;

public class TestSettings {

	//сообщения для RedHelper
	public static List<String> messages = Arrays.asList("Сообщение",
														"Привет",
														"Hello",
														"1234123412341234",
														"#$*(@^$&a");

	//невалидные номера для проверки
	public static List<String> numbers = Arrays.asList("72222222222",
														"71111111111",
														"73333333333",
														"11111111111");

	//sites with widget
	public static String urlTestSite = "http://www.tsyopa.ru/ark";	// test
	public static String urlProdSite = "http://www.vernee.ru/t";	// production

	//адреса кабинетов
	public static String urlTestMy = "http://test.redhelper.ru/my/login"; // test
	public static String urlProdMy = "http://redhelper.ru/my/login";      // production

	//autorization
	public static String rcLoginTest = "rcfree", rcPassTest = "qweasd";   // test
	public static String rcLoginProd = "krupenin", rcPassProd = "qweasd"; // production

	//зарезервированные номера
	public static String numberOperatorUnavailable = "4824244259";
	public static String numberOperatorAvailable = "74824245255";
	public static String numberOperatorHungUp = "9038099128";
	public static String numberVisitorUnavailable = "79607088020";
	public static String numberVisitorAvailable = "79094065104";

	//список невалидных номеров
	public static List<String> invalidNumbers = Arrays.asList("72222222222", "71111111111",
			"73333333333", "11111111111");
}