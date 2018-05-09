package com.petgrooming.springboot.web.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="APPOINTMENT")
public class Appointment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "APPOINTMENTID")
    private int appointmentId;
	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private GroomingOption groomingOption;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Client client;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Days day;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private TimeSlot timeslot;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private AvailableDog availableDog;
	
	@Column(name = "COMMENT")
	private String comment;
	
	@Column(name = "STATUS")
	private Boolean status;
	
	@Column(name = "APPOINTMENTDATE")
	private Date appointmentDate;

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public GroomingOption getGroomingOption() {
		return groomingOption;
	}

	public void setGroomingOption(GroomingOption groomingOption) {
		this.groomingOption = groomingOption;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Days getDay() {
		return day;
	}

	public void setDay(Days day) {
		this.day = day;
	}

	public TimeSlot getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(TimeSlot timeslot) {
		this.timeslot = timeslot;
	}

	public AvailableDog getAvailableDog() {
		return availableDog;
	}

	public void setAvailableDog(AvailableDog availableDog) {
		this.availableDog = availableDog;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointmentDate == null) ? 0 : appointmentDate.hashCode());
		result = prime * result + appointmentId;
		result = prime * result + ((availableDog == null) ? 0 : availableDog.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((groomingOption == null) ? 0 : groomingOption.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((timeslot == null) ? 0 : timeslot.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		if (appointmentDate == null) {
			if (other.appointmentDate != null)
				return false;
		} else if (!appointmentDate.equals(other.appointmentDate))
			return false;
		if (appointmentId != other.appointmentId)
			return false;
		if (availableDog == null) {
			if (other.availableDog != null)
				return false;
		} else if (!availableDog.equals(other.availableDog))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (groomingOption == null) {
			if (other.groomingOption != null)
				return false;
		} else if (!groomingOption.equals(other.groomingOption))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (timeslot == null) {
			if (other.timeslot != null)
				return false;
		} else if (!timeslot.equals(other.timeslot))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", groomingOption=" + groomingOption + ", client="
				+ client + ", day=" + day + ", timeslot=" + timeslot + ", availableDog=" + availableDog + ", comment="
				+ comment + ", status=" + status + ", appointmentDate=" + appointmentDate + "]";
	}

}
