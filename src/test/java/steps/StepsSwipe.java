package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.SwipePage;

public class StepsSwipe {

    SwipePage swipePage = new SwipePage();

    @And("I search on the carousel {string}")
    public void iClickOnTheCarousel(String text) {
        swipePage.selectCarruselOption(text);
    }

    @Then("carousel element is clickable")
    public void carouselElementIsDisplayed() {
        Assert.assertTrue(swipePage.isDisplayedCarruselOption());
    }
}


