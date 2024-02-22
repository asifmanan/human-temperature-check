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
    public void setTemperature(String temperature) {
        
        System.out.println("Temperature is " + temperature);
        float temp, oldTemp;
        oldTemp = this.temperature;
        localDateTime = now();
        try 
        {
            this.temperature = Float.parseFloat(temperature);
            pcl.propertyChange(new PropertyChangeEvent(this, "temperature", oldTemp, this.temperature));
            pcl.propertyChange(new PropertyChangeEvent(this, "feedback", "", toString()));
  
        }
        catch (Exception e)
                {
                   pcl.propertyChange(new PropertyChangeEvent(this, "feedback", 0, "Invalid entry"));
                   return;
                }

          }
    
    public String toString()
    {
        String shownTemperature = String.valueOf(this.temperature);
        if (this.temperature>37.9) return  "You should see a doctor";
        else return "You are ok";
    }
    
    private float temperature;
    
    private boolean celsius = true;
    
    private LocalDateTime localDateTime;
    
}
