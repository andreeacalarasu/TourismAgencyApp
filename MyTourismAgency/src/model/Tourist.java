package model;

public class Tourist {
    private String firstName;
    private String lastName;
    private int age;
    private String emailAddress;
    private String cityOfResidence;
    private String countryOfResidence;
    private String phoneNumber;
    private String nationalIdNumber;

    public Tourist(String firstName, String lastName, int age, String emailAddress, String cityOfResidence,
                   String countryOfResidence, String phoneNumber, String nationalIdNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.emailAddress = emailAddress;
        this.cityOfResidence = cityOfResidence;
        this.countryOfResidence = countryOfResidence;
        this.phoneNumber = phoneNumber;
        this.nationalIdNumber = nationalIdNumber;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getEmailAddress(){
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }
    public String getCityOfResidence(){
        return cityOfResidence;
    }
    public void setCityOfResidence(String cityOfResidence){
        this.cityOfResidence = cityOfResidence;
    }
    public String getCountryOfResidence(){
        return countryOfResidence;
    }
    public void setCountryOfResidence(String countryOfResidence){
        this.countryOfResidence = countryOfResidence;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getNationalIdNumber(){
        return nationalIdNumber;
    }
    public void setNationalIdNumber(String nationalIdNumber){
        this.nationalIdNumber = nationalIdNumber;
    }
    @Override
    public int hashCode(){
        int prime = 31;
        int result = prime * nationalIdNumber.hashCode();
        return result;
    }
    @Override
    public boolean equals(Object o){
        Tourist tourist = (Tourist) o;
        if(this.nationalIdNumber.equals(tourist.getNationalIdNumber())) {
            return true;
        }
        else return false;
        //return this.nationalIdNumber.equals(tourist.getNationalIdNumber());
    }
    @Override
    public String toString(){
        return "National Id Number: " + nationalIdNumber + "First Name: " + firstName + ", Last Name: " + lastName + ", Age: " + age + ", Email Address: " +
                emailAddress + ", City of Residence: " + cityOfResidence + ", Country of Residence: " +
                countryOfResidence + ", Phone Number: " + phoneNumber + "\n";
    }
}
