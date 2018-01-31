package com.jeweltot.spring.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jeweltot.spring.util.JsonDateSerializer;

@Entity
@Table(name = "entity")
public class JournalEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Date created;
    private String summary;

    @Transient
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public JournalEntity(String title, String date, String summary) throws ParseException
    {
        this.title = title;
        this.created = format.parse(date);
        this.summary = summary;
    }

    public JournalEntity()
    {

    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getCreated()
    {
        return created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    public String getSummary()
    {
        return summary;
    }

    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    @JsonIgnore
    public String getCreatedAsShort()
    {
        return format.format(created);
    }

    @Override
    public String toString()
    {
        return "JournalEntity{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", created=" + format.format(created) +
            ", summary='" + summary + '\'' +
            '}';
    }
}
