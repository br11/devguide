package br.com.santander.devguide.rdbms.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MY_ENTITY_TB")
public class MyEntityBean {

	@Id
	private long id;
	private String text;
	private Date moment;
	private double amount;

	public MyEntityBean() {
	}

	public MyEntityBean(long id, String text, Date moment, double amount) {
		super();
		this.id = id;
		this.text = text;
		this.moment = moment;
		this.amount = amount;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the moment
	 */
	public Date getMoment() {
		return moment;
	}

	/**
	 * @param moment
	 *            the moment to set
	 */
	public void setMoment(Date moment) {
		this.moment = moment;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("{id=%d, text=%s, moment=%s, amount=%f}", id, text, moment, amount);
	}

}
