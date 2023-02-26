package com.cg.mts.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverReview {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reviewId;

	public String driverName;
	public String customerName;
	private String bookingDate;
	private int starRating;
	private String reviewDate;
	private String message;

	public DriverReview(String driverName, String customerName, String bookingDate, int starRating, String reviewDate,
			String message) {
		super();
		this.driverName = driverName;
		this.customerName = customerName;
		this.bookingDate = bookingDate;
		this.starRating = starRating;
		this.reviewDate = reviewDate;
		this.message = message;
	}

}
