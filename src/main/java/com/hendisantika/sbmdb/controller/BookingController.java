/**
 * 
 */
package com.hendisantika.sbmdb.controller;

import com.hendisantika.sbmdb.models.Booking;
import com.hendisantika.sbmdb.models.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author hendisantika
 *
 */
@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingRepository bookingRepository;
	/**
	 * GET /create  --> Create a new booking and save it in the database.
	 */
	@RequestMapping("/create")
	public Map<String, Object> create(Booking booking) {
		booking.setTravelDate(new Date());
		booking = bookingRepository.save(booking);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Booking created successfully");
		dataMap.put("status", "1");
		dataMap.put("booking", booking);
	    return dataMap;
	}
	
	/**
	 * GET /read  --> Read a booking by booking id from the database.
	 */
	@RequestMapping("/read")
	public Map<String, Object> read(@RequestParam String bookingId) {
		Optional<Booking> booking = bookingRepository.findById(bookingId);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Booking found successfully");
		dataMap.put("status", "1");
		dataMap.put("booking", booking);
		return dataMap;
	}
	
	/**
	 * GET /update  --> Update a booking record and save it in the database.
	 */
	@RequestMapping("/update")
	public Map<String, Object> update(@RequestParam String bookingId, @RequestParam String psngrName) {
		Optional<Booking> bookingOpt = bookingRepository.findById(bookingId);
		Booking booking = bookingOpt.get();
		booking.setPsngrName(psngrName);
		booking = bookingRepository.save(booking);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Booking updated successfully");
		dataMap.put("status", "1");
		dataMap.put("booking", booking);
		return dataMap;
	}
	
	/**
	 * GET /delete  --> Delete a booking from the database.
	 */
	@RequestMapping("/delete")
	public Map<String, Object> delete(@RequestParam String bookingId) {
		bookingRepository.deleteById(bookingId);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Booking deleted successfully");
		dataMap.put("status", "1");
		return dataMap;
	}
	
	/**
	 * GET /read  --> Read all booking from the database.
	 */
	@RequestMapping("/read-all")
	public Map<String, Object> readAll() {
		List<Booking> bookings = bookingRepository.findAll();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Booking found successfully");
		dataMap.put("totalBooking", bookings.size());
		dataMap.put("status", "1");
		dataMap.put("bookings", bookings);
	    return dataMap;
	}
}
