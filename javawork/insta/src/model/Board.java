package model;

import java.sql.Timestamp;

public class Board {
	private long id;
	private long user_id;
	private String title;
	private String contents;
	private long views;
	private Timestamp createDate;
	private String backgroundImg;
}
