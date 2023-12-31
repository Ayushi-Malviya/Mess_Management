package com.messconnect.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.messconnect.entities.Order;
import com.messconnect.entities.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByOrderDateAndUser(LocalDate orderDate, User user);

	@Query("SELECT o FROM Order o WHERE o.user.id = ?1")
	List<Order> findOrderByUserId(Long id);

	@Modifying
	@Query("DELETE FROM Order o WHERE o.user.id= ?1")
	void deleteByUserId(Long id);
}
