package nba.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import nba.util.ArrayGroup;

public class ArrayGroupTest {

  private String[] keys;
  private double[] values;
  private String[] keys1;
  private double[] values1;

  @Before
  public void setUp() {
    keys =
        new String[] {"1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999",
            "2000"};
    values = new double[] {70, 80, 99, 5, 24, 18, 22, 33, 55, 100};

    keys1 =
        new String[] {"1991", "1994", "1995", "1997", "1999", "2000", "2003", "2004", "2005",
            "2008"};
    values1 = new double[] {70, 80, 99, 5, 24, 18, 22, 33, 55, 100};
  }

  @Test
  public void testBeginIn1990Member1() {
    String[] testKeys =
        {"1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000"};
    double[] testValues = {70, 80, 99, 5, 24, 18, 22, 33, 55, 100};
    ArrayGroup g = new ArrayGroup(keys, values, 1991, 1);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1992Member1() {
    String[] testKeys =
        {"1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000"};
    double[] testValues = {70, 80, 99, 5, 24, 18, 22, 33, 55, 100};
    ArrayGroup g = new ArrayGroup(keys, values, 1991, 1);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1992Member10NotContiguous() {
    String[] testKeys = new String[] {"1992-2001", "2002-2011"};
    double[] testValues = {226, 210};
    ArrayGroup g = new ArrayGroup(keys1, values1, 1992, 10);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1990Member4() {
    String[] testKeys = new String[] {"1990-1993", "1994-1997", "1998-2001"};
    double[] testValues = {249, 69, 188};
    ArrayGroup g = new ArrayGroup(keys, values, 1990, 4);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1990Member5() {
    String[] testKeys = new String[] {"1990-1994", "1995-1999", "2000-2004"};
    double[] testValues = {254, 152, 100};
    ArrayGroup g = new ArrayGroup(keys, values, 1990, 5);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1990Member7() {
    String[] testKeys = new String[] {"1990-1996", "1997-2003"};
    double[] testValues = {296, 210};
    ArrayGroup g = new ArrayGroup(keys, values, 1990, 7);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }



  @Test
  public void testBeginIn1990Member13() {
    String[] testKeys = new String[] {"1990-2002"};
    double[] testValues = {506};
    ArrayGroup g = new ArrayGroup(keys, values, 1990, 13);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1991Member1() {
    String[] testKeys =
        {"1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000"};
    double[] testValues = {70, 80, 99, 5, 24, 18, 22, 33, 55, 100};
    ArrayGroup g = new ArrayGroup(keys, values, 1991, 1);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1991Member2() {
    String[] testKeys =
        new String[] {"1991-1992", "1993-1994", "1995-1996", "1997-1998", "1999-2000"};
    double[] testValues = {150, 104, 42, 55, 155};
    ArrayGroup g = new ArrayGroup(keys, values, 1991, 2);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1991Member4() {
    String[] testKeys = {"1991-1994", "1995-1998", "1999-2002"};
    double[] testValues = {254, 97, 155};
    ArrayGroup g = new ArrayGroup(keys, values, 1991, 4);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1991Member5() {
    String[] testKeys = new String[] {"1991-1995", "1996-2000"};
    double[] testValues = {278, 228};
    ArrayGroup g = new ArrayGroup(keys, values, 1991, 5);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1991Member7() {
    String[] testKeys = new String[] {"1991-1997", "1998-2004"};
    double[] testValues = {318, 188};
    ArrayGroup g = new ArrayGroup(keys, values, 1991, 7);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1991Member10() {
    String[] testKeys = new String[] {"1991-2000"};
    double[] testValues = {506};
    ArrayGroup g = new ArrayGroup(keys, values, 1991, 10);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1991Member13() {
    String[] testKeys = new String[] {"1991-2003"};
    double[] testValues = {506};
    ArrayGroup g = new ArrayGroup(keys, values, 1991, 13);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }



  @Test
  public void testBeginIn1992Member2() {
    String[] testKeys =
        new String[] {"1992-1993", "1994-1995", "1996-1997", "1998-1999", "2000-2001"};
    double[] testValues = {179, 29, 40, 88, 100};
    ArrayGroup g = new ArrayGroup(keys, values, 1992, 2);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1992Member3() {
    String[] testKeys = new String[] {"1992-1994", "1995-1997", "1998-2000"};
    double[] testValues = {184, 64, 188};
    ArrayGroup g = new ArrayGroup(keys, values, 1992, 3);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1992Member4() {
    String[] testKeys = new String[] {"1992-1995", "1996-1999", "2000-2003"};
    double[] testValues = {208, 128, 100};
    ArrayGroup g = new ArrayGroup(keys, values, 1992, 4);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1992Member5() {
    String[] testKeys = new String[] {"1992-1996", "1997-2001"};
    double[] testValues = {226, 210};
    ArrayGroup g = new ArrayGroup(keys, values, 1992, 5);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1992Member7() {
    String[] testKeys = new String[] {"1992-1998", "1999-2005"};
    double[] testValues = {281, 155};
    ArrayGroup g = new ArrayGroup(keys, values, 1992, 7);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1992Member10() {
    String[] testKeys = new String[] {"1992-2001"};
    double[] testValues = {436};
    ArrayGroup g = new ArrayGroup(keys, values, 1992, 10);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1992Member13() {
    String[] testKeys = new String[] {"1992-2004"};
    double[] testValues = {436};
    ArrayGroup g = new ArrayGroup(keys, values, 1992, 13);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1991Member1NotContiguous() {
    String[] testKeys =
        new String[] {"1991", "1994", "1995", "1997", "1999", "2000", "2003", "2004", "2005",
            "2008"};
    double[] testValues = new double[] {70, 80, 99, 5, 24, 18, 22, 33, 55, 100};
    ArrayGroup g = new ArrayGroup(keys1, values1, 1991, 0);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1991Member2NotCongiguous() {
    String[] testKeys =
        new String[] {"1991-1992", "1993-1994", "1995-1996", "1997-1998", "1999-2000", "2001-2002",
            "2003-2004", "2005-2006", "2007-2008"};
    double[] testValues = {70, 80, 99, 5, 42, 0, 55, 55, 100};
    ArrayGroup g = new ArrayGroup(keys1, values1, 1991, 2);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1991Member3NotContiguous() {
    String[] testKeys =
        new String[] {"1991-1993", "1994-1996", "1997-1999", "2000-2002", "2003-2005", "2006-2008"};
    double[] testValues = {70, 179, 29, 18, 110, 100};
    ArrayGroup g = new ArrayGroup(keys1, values1, 1991, 3);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1991Member4NotContiguous() {
    String[] testKeys =
        new String[] {"1991-1994", "1995-1998", "1999-2002", "2003-2006", "2007-2010"};
    double[] testValues = {150, 104, 42, 110, 100};
    ArrayGroup g = new ArrayGroup(keys1, values1, 1991, 4);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1991Member5NotContiguous() {
    String[] testKeys = new String[] {"1991-1995", "1996-2000", "2001-2005", "2006-2010"};
    double[] testValues = {249, 47, 110, 100};
    ArrayGroup g = new ArrayGroup(keys1, values1, 1991, 5);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1991Member7NotContiguous() {
    String[] testKeys = new String[] {"1991-1997", "1998-2004", "2005-2011"};
    double[] testValues = {254, 97, 155};
    ArrayGroup g = new ArrayGroup(keys1, values1, 1991, 7);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1991Member9NotContiguous() {
    String[] testKeys = new String[] {"1991-1999", "2000-2008"};
    double[] testValues = {278, 228};
    ArrayGroup g = new ArrayGroup(keys1, values1, 1991, 9);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1991Member10NotContiguous() {
    String[] testKeys = new String[] {"1991-2000", "2001-2010"};
    double[] testValues = {296, 210};
    ArrayGroup g = new ArrayGroup(keys1, values1, 1991, 10);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1991Member11NotContiguous() {
    String[] testKeys = new String[] {"1991-2001", "2002-2012"};
    double[] testValues = {296, 210};
    ArrayGroup g = new ArrayGroup(keys1, values1, 1991, 11);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1991Member20NotContiguous() {
    String[] testKeys = new String[] {"1991-2010"};
    double[] testValues = {506};
    ArrayGroup g = new ArrayGroup(keys1, values1, 1991, 20);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1992Member2NotContiguous() {
    String[] testKeys =
        new String[] {"1992-1993", "1994-1995", "1996-1997", "1998-1999", "2000-2001", "2002-2003",
            "2004-2005", "2006-2007", "2008-2009"};
    double[] testValues = {0, 179, 5, 24, 18, 22, 88, 0, 100};
    ArrayGroup g = new ArrayGroup(keys1, values1, 1992, 2);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1992Member3NotContiguous() {
    String[] testKeys =
        new String[] {"1992-1994", "1995-1997", "1998-2000", "2001-2003", "2004-2006", "2007-2009"};
    double[] testValues = {80, 104, 42, 22, 88, 100};
    ArrayGroup g = new ArrayGroup(keys1, values1, 1992, 3);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1992Member4NotContiguous() {
    String[] testKeys =
        new String[] {"1992-1995", "1996-1999", "2000-2003", "2004-2007", "2008-2011"};
    double[] testValues = {179, 29, 40, 88, 100};
    ArrayGroup g = new ArrayGroup(keys1, values1, 1992, 4);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1992Member5NotContiguous() {
    String[] testKeys = new String[] {"1992-1996", "1997-2001", "2002-2006", "2007-2011"};
    double[] testValues = {179, 47, 110, 100};
    ArrayGroup g = new ArrayGroup(keys1, values1, 1992, 5);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1992Member7NotContiguous() {
    String[] testKeys = new String[] {"1992-1998", "1999-2005", "2006-2012"};
    double[] testValues = {184, 152, 100};
    ArrayGroup g = new ArrayGroup(keys1, values1, 1992, 7);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1992Member8NotContiguous() {
    String[] testKeys = new String[] {"1992-1999", "2000-2007", "2008-2015"};
    double[] testValues = {208, 128, 100};
    ArrayGroup g = new ArrayGroup(keys1, values1, 1992, 8);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1992Member9NotContiguous() {
    String[] testKeys = new String[] {"1992-2000", "2001-2009"};
    double[] testValues = {226, 210};
    ArrayGroup g = new ArrayGroup(keys1, values1, 1992, 9);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }

  @Test
  public void testBeginIn1992Member20NotContiguous() {
    String[] testKeys = new String[] {"1992-2011"};
    double[] testValues = {436};
    ArrayGroup g = new ArrayGroup(keys1, values1, 1992, 20);
    assertArrayEquals(testKeys, g.getCategoryGroup());
    assertArrayEquals(testValues, g.getValueGroup(), 1e-5);
  }
}
