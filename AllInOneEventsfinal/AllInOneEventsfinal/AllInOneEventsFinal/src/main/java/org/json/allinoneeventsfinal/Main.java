/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.json.allinoneeventsfinal;

/**
 *
 * @author rhiya
 */
public class Main {
    public static void main(String[] args) {

        TicketMaster ticketMaster = new TicketMaster();
        ticketMaster.getEvents("london"); //calls events in london
    }
}
