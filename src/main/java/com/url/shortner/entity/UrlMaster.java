package com.url.shortner.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "url_master")
public class UrlMaster implements Serializable {

	private static final long serialVersionUID = 319960931030361L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "url_id", nullable = false)
	private Long urlId;

	/**
	 * @Lob is an annotation used with JPA (Java Persistence API) to indicate that a
	 *      persistent property or field should be persisted as a Large Object (LOB)
	 *      in the database.
	 */
	@Lob
	@Column(name = "original_url", nullable = false)
	private String originalUrl;

	@Column(name = "shortened_url", nullable = false)
	private String shortenedUrl;

	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@Column(name = "expiration_date", nullable = true)
	private LocalDateTime expirationDate;

}
