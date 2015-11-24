/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.model;

import config.StaticInitConfig;
import enumeration.ThreatType;
import java.awt.Rectangle;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import world.Message;
import world.model.shape.Point;
import world.uav.UAVPath;

/**
 *
 * @author boluo
 */
public class Threat extends Target implements Serializable {
    
    protected float threat_range = 0;
    protected String threat_cap = "";
    protected UAVPath path_planned_at_current_time_step;
    private float current_angle = 0;
    private float[] goal;
    private int current_index_of_planned_path = 0;
    private Rectangle threat_mbr;
    private ThreatType threatType;
    
    public static int threat_width = 20;
    public static int threat_height = 20;
    
    public Threat(int index, float[] coordinates, float speed, ThreatType threatType) {
        super(index, coordinates);
        this.threatType = threatType;
        this.msg_type = Message.THREAT_MSG;
        this.speed = speed;
        this.path_planned_at_current_time_step = new UAVPath();
        threat_mbr=new Rectangle((int) coordinates[0] - Threat.threat_width / 2, (int) coordinates[1] - Threat.threat_height / 2, Threat.threat_width, Threat.threat_height);
//        rrt_alg = new RRTAlg(coordinates, null, OpStaticInitConfig.rrt_goal_toward_probability, World.bound_width, World.bound_height, OpStaticInitConfig.rrt_iteration_times, speed, null, null, -1);
    }

    public void resetCurrentIndexOfPath() {
        this.current_index_of_planned_path = -1;
    }

    public boolean moveToNextWaypoint() {
        if (this.speed == 0) {
            return true;
        }
        current_index_of_planned_path++;
        if (path_planned_at_current_time_step.getWaypointNum() == 0 || current_index_of_planned_path >= path_planned_at_current_time_step.getWaypointNum()) {
            return false;
        }
        Point current_waypoint = this.path_planned_at_current_time_step.getWaypoint(current_index_of_planned_path);
        float[] coordinate = current_waypoint.toFloatArray();
        moveTo(coordinate[0], coordinate[1]);
        this.current_angle = (float) current_waypoint.getYaw();
        return true;
    }

    /**
     *
     * @param center_coordinate_x
     * @param center_coordinate_y
     */
    public void moveTo(float center_coordinate_x, float center_coordinate_y) {
        float[] coordinate = new float[]{center_coordinate_x, center_coordinate_y};
        this.setCoordinates(coordinate);
        this.threat_mbr=new Rectangle((int) coordinates[0] - Threat.threat_width / 2, (int) coordinates[1] - Threat.threat_height / 2, Threat.threat_width, Threat.threat_height);
    }

    @Override
    public String toString() {
        return StaticInitConfig.THREAT_NAME + this.index;//this.coordinates[0]+","+this.coordinates[1]+this.threat_range+this.threat_cap;
    }

    public float getThreat_range() {
        return threat_range;
    }

    public ThreatType getThreatType() {
        return threatType;
    }

    public void setThreatType(ThreatType threatType) {
        this.threatType = threatType;
    }
    
    public void setThreat_range(float threat_range) {
        this.threat_range = threat_range;
    }

    public String getThreat_cap() {
        return threat_cap;
    }

    public float[] getGoal() {
        return goal;
    }

    public float getCurrent_angle() {
        return current_angle;
    }

    public void setCurrent_angle(float current_angle) {
        this.current_angle = current_angle;
    }

    public void setGoal(float[] goal) {
        this.goal = goal;
    }

    public void setThreat_cap(String threat_cap) {
        this.threat_cap = threat_cap;
    }

    public UAVPath getPath_planned_at_current_time_step() {
        return path_planned_at_current_time_step;
    }

    public Rectangle getThreat_mbr() {
        return threat_mbr;
    }

    public void setPath_planned_at_current_time_step(UAVPath path_planned_at_current_time_step) {
        this.path_planned_at_current_time_step = path_planned_at_current_time_step;
        this.resetCurrentIndexOfPath();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Threat) {
            Threat threat = (Threat) obj;
            if (this.index==threat.getIndex()) {//&&this.coordinates[0] == threat.coordinates[0] && this.coordinates[1] == threat.coordinates[1]
                return true;
            }
        }
        return false;
    }

    public Object deepClone() {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(this);
            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            return (oi.readObject());
        } catch (IOException ex) {
            Logger.getLogger(Target.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Target.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
}
