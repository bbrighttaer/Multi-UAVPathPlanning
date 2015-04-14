/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package experimentWithoutUI;

import config.NonStaticInitConfig;
import world.World;

/**
 *
 * @author boluo
 */
public class Experiment {

    public static void main(String[] args) {
        NonStaticInitConfig config = new NonStaticInitConfig();
        int threat_num = 5;
        int scout_num = 5;
        int attacker_num = 5;
        int[] attacker_num_list = {5, 10, 20, 50};
        int attacker_test_size = attacker_num_list.length;
        int[] obstacle_num_list = {21, 15, 10};
        int obstacle_num = 21;
        int obstacle_test_size = obstacle_num_list.length;

//        config.setScout_num(scout_num);
//        attacker_num = 5;
//        threat_num = 5;
//        config.setAttacker_num(attacker_num);
//        config.setThreat_num(threat_num);
//        for (int i = 1; i < obstacle_test_size; i++) {
//            obstacle_num = obstacle_num_list[i];
//            NonStaticInitConfig.obstacle_num = obstacle_num;
//            config.initThreats();
//            config.initObstacles();
//            for (int algorithm = 0; algorithm < 3; algorithm++) {
//                config.setInforshare_algorithm(algorithm);
//                World world = new World(config);
//                while (!world.isExperiment_over()) {
//                    world.updateAll();
//                }
//            }
//        }
        
//        config.setScout_num(scout_num);
//        NonStaticInitConfig.obstacle_num = obstacle_num;
//        config.initObstacles();
//        attacker_num = 20;
//        threat_num = attacker_num;
//        config.setAttacker_num(attacker_num);
//        config.setThreat_num(threat_num);
//        config.initThreats();
//        for (int i = 0; i < 1; i++) {
//            for (int algorithm = 2; algorithm < 3; algorithm++) {
//                config.setInforshare_algorithm(algorithm);
//                World world = new World(config);
//                while (!world.isExperiment_over()) {
//                    world.updateAll();
//                }
//            }
//        }
        
//        config.setScout_num(scout_num);
//        attacker_num = 5;
//        threat_num = attacker_num;
//        config.setAttacker_num(attacker_num);
//        config.setThreat_num(threat_num);
//        config.initThreats();
//        for (int i = 0; i < 3; i++) {
//            NonStaticInitConfig.obstacle_num = obstacle_num_list[i];
//            config.initObstacles();
//            for (int algorithm = 0; algorithm < 3; algorithm++) {
//                config.setInforshare_algorithm(algorithm);
//                World world = new World(config);
//                while (!world.isExperiment_over()) {
//                    world.updateAll();
//                }
//            }
//        }

        int[] scout_num_list = {3, 5, 10};
        threat_num = 5;
        attacker_num = 5;
        config.setAttacker_num(attacker_num);
        config.setThreat_num(threat_num);
        config.initObstacles();
        config.initThreats();
        int scout_test_size = scout_num_list.length;
        for (int i = 0; i < 3; i++) {
            for (int algorithm = 0; algorithm < 3; algorithm++) {
                scout_num = scout_num_list[i];
                config.setScout_num(scout_num);
                config.setInforshare_algorithm(algorithm);
                World world = new World(config);
                while (!world.isExperiment_over()) {
                    world.updateAll();
                }
            }
        }
    }
}