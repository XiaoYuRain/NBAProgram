package nba.test;

import nba.controler.DataLoadingControler;
import nba.loader.DataLoader;
import nba.model.Catalog;
import nba.parser.DataParser;

import org.junit.Assert;
import org.junit.Test;

public class DataLoadingControlerTest {

  @Test
  public void dataLoadingTest() {
    DataLoadingControler dataLoadingControler =
        new DataLoadingControler(new DataLoader(), new DataParser());
    // 与文件位置耦合很紧，不知该如何改进
    dataLoadingControler.loadData("NBA_data.csv");
    Catalog catalog = Catalog.getInstance();

    Assert.assertEquals(19197, catalog.getSeasons().size());
    Assert.assertEquals(3881, catalog.getPlayers().size());
    Assert.assertEquals(274, catalog.getCoachs().size());
    Assert.assertEquals(98, catalog.getArenas().size());
    Assert.assertEquals(58, catalog.getTeams().size());
    Assert.assertEquals(542, catalog.getCoachTeams().size());
    Assert.assertEquals(110, catalog.getArenaTeams().size());
    Assert.assertEquals(111, catalog.getLocations().size());
  }
}
