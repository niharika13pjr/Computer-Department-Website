package model;
import java.util.Date;
public class discuss {
private int id;
private int parentID;
private String content;

private Date postedDate;



public Date getpostedDate()
{
	return this.postedDate; 
}

public int getParentId()
{
	return this.parentID;
}

public int getId()
{
	return this.id;
}

public String getcontent()
{
	return this.content;
}


public void setpostedDate(Date pDate)
{
	this.postedDate=pDate; 
}

public void setParentId(int pId)
{
	this.parentID=pId;
}

public void setId(int id)
{
	this.id=id;
}

public void setcontent(String cont)
{
	this.content=cont;
}

}
