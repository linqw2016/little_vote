package com.graphqljava.little_vote.bean;

import java.io.Serializable;
import java.util.List;

public class Vote implements Serializable {
    private List<String> selectedPersons;
    private Ticket ticket;

    public Vote(List<String> selectedPersons, Ticket ticket) {
        this.selectedPersons = selectedPersons;
        this.ticket = ticket;
    }

    public List<String> getSelectedPersons() {
        return selectedPersons;
    }

    public void setSelectedPersons(List<String> selectedPersons) {
        this.selectedPersons = selectedPersons;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
