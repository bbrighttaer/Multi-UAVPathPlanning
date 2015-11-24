/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphAnalysisAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ui.AnimationPanel;
import world.World;
import world.model.Conflict;
import world.model.Obstacle;
import world.model.Threat;
import world.uav.Attacker;
import world.uav.Scout;
import world.uav.UAV;

/**
 * <p>
 * This class is to be used by the graph module to access 
 * the necessary info from the simulation to perform the 
 * analysis.
 * </p>
 * <p>
 * All graph analysis data provisioning are to use APIs in this class
 * </p>
 * @author AG BRIGHTER
 */
public class GraphAPI 
{
    private final AnimationPanel animationPanel;
    private final ArrayList<Attacker> attackers;
    private final ArrayList<Scout> scouts;
    private final ArrayList<Conflict> conflicts;
    private final List<Threat> threats;
    private final ArrayList<Obstacle> obstacles;
    private Threat selectedTask;    
    
    /**
     * Constructor for creating an object of the class.
     * It has private access to control the constraint of having an <code>AnimationPanel</code> object
     * prior to the access of the APIs of this class
     * @param animationPanel 
     */
    private GraphAPI(AnimationPanel animationPanel)
    {
        World w = animationPanel.getWorld();
        this.animationPanel = animationPanel;        
        this.attackers = animationPanel.getAttackers();
        this.scouts = animationPanel.getScouts();
        this.conflicts = w.getConflicts();
        this.threats = w.getThreats();
        this.obstacles = w.getObstacles();
    }
    
    /**
     * A list of all Attacker UAVs
     * @return 
     */
    public List<Attacker> getAttackers() {
        return Collections.unmodifiableList(attackers);
    }

    public AnimationPanel getAnimationPanel() {
        return animationPanel;
    }
    
    /**
     * Gets a list of all Scout UAVs in the world
     * @return 
     */
    public List<Scout> getScouts() {
        return Collections.unmodifiableList(scouts);
    }
    
    /**
     * Gets a list of all conflicts in the world
     * @return 
     */
    public List<Conflict> getConflicts() {
        return Collections.unmodifiableList(conflicts);
    }
    
    /**
     * Gets a list of all threats/tasks in the world
     * @return 
     */
    public List<Threat> getThreats() {
        return Collections.unmodifiableList(threats);
    }
    
    /**
     * Gets the list of all obstacles in the world
     * @return 
     */
    public List<Obstacle> getObstacles() {
        return Collections.unmodifiableList(obstacles);
    }
    
    /**
     * Gets a selected Task/Threat
     * @return The Selected task/threat
     */
    public Threat getSelectedTask() {
        return selectedTask;
    }      
    
    /**
     * Sets the selected task/threat. This is initiated by the user from the 
     * animation user interface. The task/threat is determined on mouse clicked
     * @param selectedTask 
     */
    public void setSelectedTask(Threat selectedTask) {
        this.selectedTask = selectedTask;
    }
    
    /**
     * Gets the center of a given UAV
     * @param uav
     * @return 
     */
    public float[] getCenterCoordinatesOfUAV(UAV uav)
    {
        return uav.getCenter_coordinates();
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="Graph API object factory">
    /**
     * Inner object factory to ensure animation is provided before an
     * instance of the GraphAPI can be provided
     */
    public static class GraphAPIobjectFactory
    {
        /**
         * Creates an instance of {@link GraphAPI}
         * @param animationPanel
         * @return an GraphAPI object that satisfies the a-priori animationPanel constraint
         */
        public static GraphAPI createGraphAPIobject(AnimationPanel animationPanel)
        {
            return new GraphAPI(animationPanel);
        }
    }
//</editor-fold>
}
