package models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.CreatedTimestamp;

@Entity
public class Line extends Model {

    private static final long serialVersionUID = 1L;

    @Id
    public String datetime;

    @NotNull
    public BigDecimal temperature;

    @CreatedTimestamp
    public Date createDate;

    public String toString() {
        return "Line [datetime=" + datetime + ", temperature=" + temperature
                + "]";
    }
}
