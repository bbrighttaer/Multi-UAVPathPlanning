/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumeration;

/**
 *  Types of scout UAVs
 * @author AG BRIGHTER
 */
public enum ScoutType {
    TYPE0(0),
    TYPE1(1),
    TYPE2(2),
    TYPE3(3),
    TYPE4(4),
    TYPE5(5);
    
    private int type;

    private ScoutType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}