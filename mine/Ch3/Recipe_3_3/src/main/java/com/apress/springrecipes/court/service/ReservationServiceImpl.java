package com.apress.springrecipes.court.service;

import com.apress.springrecipes.court.domain.Player;
import com.apress.springrecipes.court.domain.Reservation;
import com.apress.springrecipes.court.domain.SportType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService{

    private static final SportType TENNIS = new SportType(1, "Tennis");
    private static final SportType SOCCER = new SportType(2, "Soccer");

    private final List<Reservation> reservations = new ArrayList<>();

    public ReservationServiceImpl() {
        reservations.add(new Reservation("Tennis #1"
                , new GregorianCalendar(2008, 0, 14).getTime()
                ,16
                , new Player("Roger", "N/A")
                , TENNIS));

        reservations.add(new Reservation("Tennis #2"
                , new GregorianCalendar(2008, 0, 14).getTime()
                , 20
                , new Player("James", "N/A")
                , TENNIS));


    }

    @Override
    public List<Reservation> query(String courtName) {

//        return this.reservations.stream()
//                .filter(new Predicate<Reservation>() {
//                    @Override
//                    public boolean test(Reservation reservation) {
//                        return Objects.equals(reservation.getCourtName(), courtName);
//                    }
//                }).collect(Collectors.toList());

        return this.reservations.stream()
                .filter(reservation -> Objects.equals(reservation.getCourtName(), courtName))
                .collect(Collectors.toList());
    }
}
