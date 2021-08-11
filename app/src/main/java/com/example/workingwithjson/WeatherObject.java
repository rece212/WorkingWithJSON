package com.example.workingwithjson;

public class WeatherObject
{
    private String ID;
    private String weatherStateName;
    private String WeatherStateAbbr;
    private String winddirectioncompass;
    private String created;
    private String applicabledate;
    private String min_temp;
    private String max_temp;
    private String the_temp;
    private String wind_speed;
    private String wind_direction;
    private String air_pressure;
    private String humidity;
    private String visibility;
    private String predictability;

    public WeatherObject()
    {

    }

    public WeatherObject(String ID, String weatherStateName, String weatherStateAbbr, String winddirectioncompass, String created, String applicabledate, String min_temp, String max_temp, String the_temp, String wind_speed, String wind_direction, String air_pressure, String humidity, String visibility, String predictability) {
        this.ID = ID;
        this.weatherStateName = weatherStateName;
        WeatherStateAbbr = weatherStateAbbr;
        this.winddirectioncompass = winddirectioncompass;
        this.created = created;
        this.applicabledate = applicabledate;
        this.min_temp = min_temp;
        this.max_temp = max_temp;
        this.the_temp = the_temp;
        this.wind_speed = wind_speed;
        this.wind_direction = wind_direction;
        this.air_pressure = air_pressure;
        this.humidity = humidity;
        this.visibility = visibility;
        this.predictability = predictability;
    }

    @Override
    public String toString() {
        return
                ", weatherStateName='" + weatherStateName + '\'' +
                ", winddirectiondcompass='" + winddirectioncompass + '\'' +
                ", applicabledate='" + applicabledate + '\'' +
                ", min_temp='" + min_temp + '\'' +
                ", max_temp='" + max_temp + '\'' +
                ", wind_speed='" + wind_speed + '\'' +
                ", wind_direction='" + wind_direction + '\'' +
                ", humidity='" + humidity + '\'' ;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getWeatherStateName() {
        return weatherStateName;
    }

    public void setWeatherStateName(String weatherStateName) {
        this.weatherStateName = weatherStateName;
    }

    public String getWeatherStateAbbr() {
        return WeatherStateAbbr;
    }

    public void setWeatherStateAbbr(String weatherStateAbbr) {
        WeatherStateAbbr = weatherStateAbbr;
    }

    public String getWinddirectioncompass() {
        return winddirectioncompass;
    }

    public void setWinddirectioncompass(String winddirectioncompass) {
        this.winddirectioncompass = winddirectioncompass;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getApplicabledate() {
        return applicabledate;
    }

    public void setApplicabledate(String applicabledate) {
        this.applicabledate = applicabledate;
    }

    public String getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(String min_temp) {
        this.min_temp = min_temp;
    }

    public String getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(String max_temp) {
        this.max_temp = max_temp;
    }

    public String getThe_temp() {
        return the_temp;
    }

    public void setThe_temp(String the_temp) {
        this.the_temp = the_temp;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(String wind_speed) {
        this.wind_speed = wind_speed;
    }

    public String getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(String wind_direction) {
        this.wind_direction = wind_direction;
    }

    public String getAir_pressure() {
        return air_pressure;
    }

    public void setAir_pressure(String air_pressure) {
        this.air_pressure = air_pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getPredictability() {
        return predictability;
    }

    public void setPredictability(String predictability) {
        this.predictability = predictability;
    }
}
