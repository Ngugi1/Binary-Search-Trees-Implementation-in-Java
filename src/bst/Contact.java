package bst;
/**
 *
 * @author Ngugi
 */
public class Contact 
{
    private long telephoneNumber;
    private String first_name;
    private String last_name;
    
    public void setTelephone(long telephone){
        this.telephoneNumber = telephone;
    }
    public long getTelephone(){
        return this.telephoneNumber;
    }
    
    public void setFirstName(String fname){
        this.first_name = fname;
    }
    public String getFirstName()
    {
        return this.first_name;
    }
    public void setLastName(String lname){
    this.last_name = lname;
    }
    public String getLastName()
    {
        return this.last_name;
    }}

