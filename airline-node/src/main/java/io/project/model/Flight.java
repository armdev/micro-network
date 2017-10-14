/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "flights")
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "Year")
    private Integer year;
    @Column(name = "Quarter")
    private Integer quarter;
    @Column(name = "Month")
    private Integer month;
    @Column(name = "DayofMonth")
    private Integer dayofMonth;
    @Column(name = "DayOfWeek")
    private Integer dayOfWeek;
    @Column(name = "FlightDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date flightDate;
    @Size(max = 2)
    @Column(name = "UniqueCarrier")
    private String uniqueCarrier;
    @Column(name = "AirlineID")
    private Integer airlineID;
    @Size(max = 2)
    @Column(name = "Carrier")
    private String carrier;
    @Size(max = 6)
    @Column(name = "TailNum")
    private String tailNum;
    @Column(name = "FlightNum")
    private Integer flightNum;
    @Column(name = "OriginAirportID")
    private Integer originAirportID;
    @Column(name = "OriginAirportSeqID")
    private Integer originAirportSeqID;
    @Column(name = "OriginCityMarketID")
    private Integer originCityMarketID;
    @Size(max = 3)
    @Column(name = "Origin")
    private String origin;
    @Size(max = 30)
    @Column(name = "OriginCityName")
    private String originCityName;
    @Size(max = 2)
    @Column(name = "OriginState")
    private String originState;
    @Column(name = "OriginStateFips")
    private Integer originStateFips;
    @Size(max = 14)
    @Column(name = "OriginStateName")
    private String originStateName;
    @Column(name = "OriginWac")
    private Integer originWac;
    @Column(name = "DestAirportID")
    private Integer destAirportID;
    @Column(name = "DestAirportSeqID")
    private Integer destAirportSeqID;
    @Column(name = "DestCityMarketID")
    private Integer destCityMarketID;
    @Size(max = 3)
    @Column(name = "Dest")
    private String dest;
    @Size(max = 21)
    @Column(name = "DestCityName")
    private String destCityName;
    @Size(max = 2)
    @Column(name = "DestState")
    private String destState;
    @Column(name = "DestStateFips")
    private Integer destStateFips;
    @Size(max = 14)
    @Column(name = "DestStateName")
    private String destStateName;
    @Column(name = "DestWac")
    private Integer destWac;
    @Column(name = "CRSDepTime")
    private Integer cRSDepTime;
    @Column(name = "DepTime")
    private Integer depTime;
    @Column(name = "DepDelay")
    private Integer depDelay;
    @Column(name = "DepDelayMinutes")
    private Integer depDelayMinutes;
    @Column(name = "DepDel15")
    private Integer depDel15;
    @Column(name = "DepartureDelayGroups")
    private Integer departureDelayGroups;
    @Size(max = 9)
    @Column(name = "DepTimeBlk")
    private String depTimeBlk;
    @Column(name = "TaxiOut")
    private Integer taxiOut;
    @Column(name = "WheelsOff")
    private Integer wheelsOff;
    @Column(name = "WheelsOn")
    private Integer wheelsOn;
    @Column(name = "TaxiIn")
    private Integer taxiIn;
    @Column(name = "CRSArrTime")
    private Integer cRSArrTime;
    @Column(name = "ArrTime")
    private Integer arrTime;
    @Column(name = "ArrDelay")
    private Integer arrDelay;
    @Column(name = "ArrDelayMinutes")
    private Integer arrDelayMinutes;
    @Column(name = "ArrDel15")
    private Integer arrDel15;
    @Column(name = "ArrivalDelayGroups")
    private Integer arrivalDelayGroups;
    @Size(max = 9)
    @Column(name = "ArrTimeBlk")
    private String arrTimeBlk;
    @Column(name = "Cancelled")
    private Integer cancelled;
    @Size(max = 1)
    @Column(name = "CancellationCode")
    private String cancellationCode;
    @Column(name = "Diverted")
    private Integer diverted;
    @Column(name = "CRSElapsedTime")
    private Integer cRSElapsedTime;
    @Column(name = "ActualElapsedTime")
    private Integer actualElapsedTime;
    @Column(name = "AirTime")
    private Integer airTime;
    @Column(name = "Flights")
    private Integer flights;
    @Column(name = "Distance")
    private Integer distance;
    @Column(name = "DistanceGroup")
    private Integer distanceGroup;

    public Flight() {
    }

    public Flight(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDayofMonth() {
        return dayofMonth;
    }

    public void setDayofMonth(Integer dayofMonth) {
        this.dayofMonth = dayofMonth;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public String getUniqueCarrier() {
        return uniqueCarrier;
    }

    public void setUniqueCarrier(String uniqueCarrier) {
        this.uniqueCarrier = uniqueCarrier;
    }

    public Integer getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(Integer airlineID) {
        this.airlineID = airlineID;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getTailNum() {
        return tailNum;
    }

    public void setTailNum(String tailNum) {
        this.tailNum = tailNum;
    }

    public Integer getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(Integer flightNum) {
        this.flightNum = flightNum;
    }

    public Integer getOriginAirportID() {
        return originAirportID;
    }

    public void setOriginAirportID(Integer originAirportID) {
        this.originAirportID = originAirportID;
    }

    public Integer getOriginAirportSeqID() {
        return originAirportSeqID;
    }

    public void setOriginAirportSeqID(Integer originAirportSeqID) {
        this.originAirportSeqID = originAirportSeqID;
    }

    public Integer getOriginCityMarketID() {
        return originCityMarketID;
    }

    public void setOriginCityMarketID(Integer originCityMarketID) {
        this.originCityMarketID = originCityMarketID;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOriginCityName() {
        return originCityName;
    }

    public void setOriginCityName(String originCityName) {
        this.originCityName = originCityName;
    }

    public String getOriginState() {
        return originState;
    }

    public void setOriginState(String originState) {
        this.originState = originState;
    }

    public Integer getOriginStateFips() {
        return originStateFips;
    }

    public void setOriginStateFips(Integer originStateFips) {
        this.originStateFips = originStateFips;
    }

    public String getOriginStateName() {
        return originStateName;
    }

    public void setOriginStateName(String originStateName) {
        this.originStateName = originStateName;
    }

    public Integer getOriginWac() {
        return originWac;
    }

    public void setOriginWac(Integer originWac) {
        this.originWac = originWac;
    }

    public Integer getDestAirportID() {
        return destAirportID;
    }

    public void setDestAirportID(Integer destAirportID) {
        this.destAirportID = destAirportID;
    }

    public Integer getDestAirportSeqID() {
        return destAirportSeqID;
    }

    public void setDestAirportSeqID(Integer destAirportSeqID) {
        this.destAirportSeqID = destAirportSeqID;
    }

    public Integer getDestCityMarketID() {
        return destCityMarketID;
    }

    public void setDestCityMarketID(Integer destCityMarketID) {
        this.destCityMarketID = destCityMarketID;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getDestCityName() {
        return destCityName;
    }

    public void setDestCityName(String destCityName) {
        this.destCityName = destCityName;
    }

    public String getDestState() {
        return destState;
    }

    public void setDestState(String destState) {
        this.destState = destState;
    }

    public Integer getDestStateFips() {
        return destStateFips;
    }

    public void setDestStateFips(Integer destStateFips) {
        this.destStateFips = destStateFips;
    }

    public String getDestStateName() {
        return destStateName;
    }

    public void setDestStateName(String destStateName) {
        this.destStateName = destStateName;
    }

    public Integer getDestWac() {
        return destWac;
    }

    public void setDestWac(Integer destWac) {
        this.destWac = destWac;
    }

    public Integer getCRSDepTime() {
        return cRSDepTime;
    }

    public void setCRSDepTime(Integer cRSDepTime) {
        this.cRSDepTime = cRSDepTime;
    }

    public Integer getDepTime() {
        return depTime;
    }

    public void setDepTime(Integer depTime) {
        this.depTime = depTime;
    }

    public Integer getDepDelay() {
        return depDelay;
    }

    public void setDepDelay(Integer depDelay) {
        this.depDelay = depDelay;
    }

    public Integer getDepDelayMinutes() {
        return depDelayMinutes;
    }

    public void setDepDelayMinutes(Integer depDelayMinutes) {
        this.depDelayMinutes = depDelayMinutes;
    }

    public Integer getDepDel15() {
        return depDel15;
    }

    public void setDepDel15(Integer depDel15) {
        this.depDel15 = depDel15;
    }

    public Integer getDepartureDelayGroups() {
        return departureDelayGroups;
    }

    public void setDepartureDelayGroups(Integer departureDelayGroups) {
        this.departureDelayGroups = departureDelayGroups;
    }

    public String getDepTimeBlk() {
        return depTimeBlk;
    }

    public void setDepTimeBlk(String depTimeBlk) {
        this.depTimeBlk = depTimeBlk;
    }

    public Integer getTaxiOut() {
        return taxiOut;
    }

    public void setTaxiOut(Integer taxiOut) {
        this.taxiOut = taxiOut;
    }

    public Integer getWheelsOff() {
        return wheelsOff;
    }

    public void setWheelsOff(Integer wheelsOff) {
        this.wheelsOff = wheelsOff;
    }

    public Integer getWheelsOn() {
        return wheelsOn;
    }

    public void setWheelsOn(Integer wheelsOn) {
        this.wheelsOn = wheelsOn;
    }

    public Integer getTaxiIn() {
        return taxiIn;
    }

    public void setTaxiIn(Integer taxiIn) {
        this.taxiIn = taxiIn;
    }

    public Integer getCRSArrTime() {
        return cRSArrTime;
    }

    public void setCRSArrTime(Integer cRSArrTime) {
        this.cRSArrTime = cRSArrTime;
    }

    public Integer getArrTime() {
        return arrTime;
    }

    public void setArrTime(Integer arrTime) {
        this.arrTime = arrTime;
    }

    public Integer getArrDelay() {
        return arrDelay;
    }

    public void setArrDelay(Integer arrDelay) {
        this.arrDelay = arrDelay;
    }

    public Integer getArrDelayMinutes() {
        return arrDelayMinutes;
    }

    public void setArrDelayMinutes(Integer arrDelayMinutes) {
        this.arrDelayMinutes = arrDelayMinutes;
    }

    public Integer getArrDel15() {
        return arrDel15;
    }

    public void setArrDel15(Integer arrDel15) {
        this.arrDel15 = arrDel15;
    }

    public Integer getArrivalDelayGroups() {
        return arrivalDelayGroups;
    }

    public void setArrivalDelayGroups(Integer arrivalDelayGroups) {
        this.arrivalDelayGroups = arrivalDelayGroups;
    }

    public String getArrTimeBlk() {
        return arrTimeBlk;
    }

    public void setArrTimeBlk(String arrTimeBlk) {
        this.arrTimeBlk = arrTimeBlk;
    }

    public Integer getCancelled() {
        return cancelled;
    }

    public void setCancelled(Integer cancelled) {
        this.cancelled = cancelled;
    }

    public String getCancellationCode() {
        return cancellationCode;
    }

    public void setCancellationCode(String cancellationCode) {
        this.cancellationCode = cancellationCode;
    }

    public Integer getDiverted() {
        return diverted;
    }

    public void setDiverted(Integer diverted) {
        this.diverted = diverted;
    }

    public Integer getCRSElapsedTime() {
        return cRSElapsedTime;
    }

    public void setCRSElapsedTime(Integer cRSElapsedTime) {
        this.cRSElapsedTime = cRSElapsedTime;
    }

    public Integer getActualElapsedTime() {
        return actualElapsedTime;
    }

    public void setActualElapsedTime(Integer actualElapsedTime) {
        this.actualElapsedTime = actualElapsedTime;
    }

    public Integer getAirTime() {
        return airTime;
    }

    public void setAirTime(Integer airTime) {
        this.airTime = airTime;
    }

    public Integer getFlights() {
        return flights;
    }

    public void setFlights(Integer flights) {
        this.flights = flights;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getDistanceGroup() {
        return distanceGroup;
    }

    public void setDistanceGroup(Integer distanceGroup) {
        this.distanceGroup = distanceGroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.project.model.Flight[ id=" + id + " ]";
    }
    
}
