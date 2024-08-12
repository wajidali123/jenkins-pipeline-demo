package com.spring.session.demo.controllers;

import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;

public class Main {
    public static void main(String[] args) {
        var arr1 = new int[] {1, 2, 3, 4,5,6,7,8};
        var arr2 = new int[] {9,10,11,12,13,14,15,16};
        
        VectorSpecies<Integer> SPECIES = IntVector.SPECIES_PREFERRED;
        if (arr1.length < SPECIES.length() || arr2.length < SPECIES.length()) {
            throw new IllegalArgumentException("Array length is less than the vector size.");
        }

        var v1 = IntVector.fromArray(SPECIES, arr1, 0);
        var v2 = IntVector.fromArray(SPECIES, arr2, 0);


        var result = v1.add(v2);
        var multiplication = v1.mul(v2);
    }
}
