/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serverwofacade;

/**
 *
 * @author sarun
 */
public class ScheduleServer {
    private static ScheduleServer myScheduleServerObject = null;
        private ScheduleServer() {}
        public static ScheduleServer getScheduleServerObject() {
            if (myScheduleServerObject == null) {
                myScheduleServerObject = new ScheduleServer() ;
            }
            return myScheduleServerObject;
        }
        public void startSchedule() {
            Start obj = new Start();
            obj.startBooting();
            obj.readSystemConfigFile();
            obj.init();
            obj.initializeContext();
            obj.initializeListeners();
            obj.createSystemObjects();
        }
        public void destorySchedule() {
            Destory obj = new Destory();
            obj.releaseProcesses();
            obj.destory();
            obj.destroySystemObjects();
            obj.destoryListeners();
            obj.destoryContext();
            obj.shutdown();
        }

}
