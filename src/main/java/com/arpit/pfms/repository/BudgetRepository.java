package com.arpit.pfms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arpit.pfms.entity.Budget;
import com.arpit.pfms.entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

    List<Budget> findByUser(User user);

    Optional<Budget> findByUserAndCategoryAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            User user, String category, LocalDate date1, LocalDate date2);
}