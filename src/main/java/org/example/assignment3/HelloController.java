package org.example.assignment3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.List;

public class HelloController {
    @FXML
    private Text planetInformation;

    @FXML
    private TextField planetTextField;

    @FXML
    protected void onSearchButtonClick() {
        String make = planetTextField.getText();


        if (!make.isEmpty()) {
            PlanetApiUtility planetApiUtility = new PlanetApiUtility();
            List<Planet> planets = planetApiUtility.fetchPlanetData(make);

            // Display information of the first planet in the list
            if (!planets.isEmpty()) {
                Planet planet = planets.getFirst();
                String planetInfo = String.format("Name: %s \nMass: %s \nRadius: %s \nOrbital Period: %d Days \nSemi Major Axis: %f AU \nTemperature: %s Kelvin\nDistance: %f light year \nHost Star Mass: 1.898 × 10^27 kg \nHost Star Temperature: 6000 Kelvin \n",
                        planet.getName(), planet.getMass(), planet.getRadius(), planet.getPeriod(), planet.getSemi_Major_Axis(), planet.getTemperature(), planet.getDistance_Light_Year() );
                String planetinfo2 = planet.getBriefDescription();
                planetInformation.setText(planetInfo+planetinfo2);
            } else {
                planetInformation.setText("No planet information available.");
            }
        } else {
            planetInformation.setText("Please enter a planet name.");
        }
    }

    @FXML
    public void reset(ActionEvent actionEvent) {
        // Clear the text of the planetInformation Text and planetTextField
        planetInformation.setText("");
        planetTextField.clear();
    }
}