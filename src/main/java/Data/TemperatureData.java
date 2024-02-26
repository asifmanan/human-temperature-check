/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author comqsjb
 */
public class TemperatureData {

   
    
    PropertyChangeListener pcl;
    public float getTemperature() {
        return temperature;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener outsidePcl)
    {
        this.pcl = outsidePcl;
    }

    /**
     * @param temperature the temperature to set
     */
    public float convertToCelsius(float temperature){
        return ( (temperature - 32) * 5/9 );
    }
    
//    public void setTemperature(String temperature, boolean isCelsius)  {
    public void setTemperature(String temperature)  {
        
        System.out.println("Temperature is " + temperature);
        float temp, oldTemp;
        oldTemp = this.temperature;
        localDateTime = now();
        try 
        {
            this.temperature = Float.parseFloat(temperature);
            
            if (!celsius){
                this.temperature = this.convertToCelsius(this.temperature);
                System.out.println("converted to celsius: " + this.temperature);
            }
            
            pcl.propertyChange(new PropertyChangeEvent(this, "temperature", oldTemp, this.temperature));
            pcl.propertyChange(new PropertyChangeEvent(this, "feedback", "", toString()));
  
        }
        catch (Exception e)
                {
                   pcl.propertyChange(new PropertyChangeEvent(this, "feedback", 0, "Invalid entry"));
                   return;
                }

          }
    
    public String toString() {
        String shownTemperature = String.valueOf(this.temperature);
        if (this.temperature > 37.9) return  "Your temperature is high, please see a doctor";
        else {
            return "You are ok";
        }
    }
    
    public void setCelciusScale(){
        this.celsius = true;
    }
    
    public void setFahrenheitScale(){
        this.celsius = false;
    }
    
    private float temperature;
    private boolean celsius = true;
    private LocalDateTime localDateTime;
    
}
