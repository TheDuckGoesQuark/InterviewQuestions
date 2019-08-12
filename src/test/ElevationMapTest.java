package test;

import main.elevationmap.ElevationMap;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElevationMapTest {

    @Test
    public void getVolumeContainable() {
        assertEquals(1, ElevationMap.getVolumeContainable(new int[]{1, 0, 1}));
        assertEquals(5, ElevationMap.getVolumeContainable(new int[]{5, 0, 5}));
        assertEquals(3, ElevationMap.getVolumeContainable(new int[]{3, 0, 5}));
        assertEquals(3, ElevationMap.getVolumeContainable(new int[]{5, 0, 3}));
        assertEquals(8, ElevationMap.getVolumeContainable(new int[]{3, 0, 1, 3, 0, 5}));
        assertEquals(1, ElevationMap.getVolumeContainable(new int[]{2, 1, 2}));
        assertEquals(0, ElevationMap.getVolumeContainable(new int[]{0, 1, 3}));
        assertEquals(0, ElevationMap.getVolumeContainable(new int[]{5, 5, 5}));
        assertEquals(4, ElevationMap.getVolumeContainable(new int[]{5, 4, 3, 4, 5}));
        assertEquals(8, ElevationMap.getVolumeContainable(new int[]{5, 4, 3, 4, 5, 4, 3, 4, 5}));
        assertEquals(1, ElevationMap.getVolumeContainable(new int[]{5, 4, 4, 3, 4, 4}));
    }
}