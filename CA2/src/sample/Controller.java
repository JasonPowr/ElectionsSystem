/**
 * Author's - Jason Power & Oskar Svalbe
 */

package sample;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.TilePane;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.*;
import java.net.IDN;
import java.util.ArrayList;

public class Controller {
    public PoliticanList pL = new PoliticanList();
    public ElectionList eL = new ElectionList();
    public CandidateList cL = new CandidateList();

    public Alert alert = new Alert(Alert.AlertType.ERROR);
    public TextField tx = new TextField();

    public TextField nameOfPolitician, dateOfBirth, party, homeCounty;
    public Button deletePolitican;
    public TextField politicianForDeletion;
    public TextArea listOfPolitican;
    public Button searchForUpdate;
    public TextField politicianForUpdate;

    public Button addElection;
    public TextField electionId, electionType, electionLocation, yearDate, noOfSeats;
    public TextArea listOfElections;
    public Button updateElectionInfo;
    public Button deleteElection;
    public TextField electionForDeletion;
    public Button seacrhForElectionUpdate;
    public TextField idForUpdate;

    public TextArea listOfElectionforCandidate;
    public Button findELectionForCandidate;
    public TextField electionIdForCandidate;
    public TextArea listOfPolititciansForCandidate;
    public Button findPolititcianForCandidate;
    public Button addPoliticianToElection;
    public Button RemoveAPoliticianFromAnElection;
    public TextField numberOfVotesForCandidate;
    public TextField nameOfPoliticianForCandidate;
    public TextArea fullList;
    public Button listPoliticians;
    public Button listElections;
    public Button listCandidates;
    public Button searchElectionByType;
    public TextField electionTypeForSearch;
    public Button searchElectionByYear;
    public TextField electionYearForSearch;
    public Button searchPolitionsbyParty;
    public TextField politionPartyForSearch;
    public Button searchPolByLocation;
    public TextField locationForSearch;
    public Button listCandidatesOfElection;
    public TextField iDforCandidates;
    public Button sortNameInAscendingOrder;
    public Button sortElectionByVotes;
    public Button save;
    public Button load;


    /**
     * Adds a Politician
     */

    public void addPolitician() {
        String nameOfPoliticianString = nameOfPolitician.getText();
        String dateOfBirthString = dateOfBirth.getText();
        String partyString = party.getText();
        String homeCountyString = homeCounty.getText();

        if ((nameOfPoliticianString.equals("")) || (dateOfBirthString.equals("")) || (partyString.equals("")) || (homeCountyString.equals(""))) {
            alert.setContentText("PLEASE ENTER ALL INFORMATION");
            alert.show();
        } else {
            pL.addPolitican(new Politican(nameOfPoliticianString, dateOfBirthString, partyString, homeCountyString) {
            });
            nameOfPolitician.clear();
            dateOfBirth.clear();
            party.clear();
            homeCounty.clear();

            listOfPolitican.setText(pL.listPoliticians());
            listOfPolititciansForCandidate.setText(pL.listPoliticians());
        }
    }

    /**
     * Deletes a Politician
     */

    public void deletePolitican() {
        String politicianForDeletionString = politicianForDeletion.getText();
        if (politicianForDeletionString.isEmpty()) {
            alert.setContentText("No politician Selected");
            alert.show();
        } else {
            pL.deletePolitican(politicianForDeletionString);
            politicianForDeletion.clear();

            listOfPolitican.setText(pL.listPoliticians());
            listOfPolititciansForCandidate.setText(pL.listPoliticians());
        }
    }


    /**
     * Updates a Politician
     */

    public void updatePolitician() {
        String newNameOfPoliticianString = nameOfPolitician.getText();
        String newDateOfBirthString = dateOfBirth.getText();
        String newPartyString = party.getText();
        String newHomeCountyString = homeCounty.getText();

        searchForUpdate().setDateOfBirth(newDateOfBirthString);
        searchForUpdate().setParty(newPartyString);
        searchForUpdate().setHomeCounty(newHomeCountyString);
        searchForUpdate().setName(newNameOfPoliticianString);

        listOfPolitican.setText(pL.listPoliticians());
        listOfPolititciansForCandidate.setText(pL.listPoliticians());

        nameOfPolitician.clear();
        dateOfBirth.clear();
        party.clear();
        homeCounty.clear();
        politicianForUpdate.clear();
    }

    /**
     * Searches for Politician to Update
     */

    public Politican searchForUpdate() {
        String politicianForUpdateString = politicianForUpdate.getText();
        Politican foundPolitician = null;

        if (politicianForUpdateString.isEmpty()) {
            alert.setContentText("No politician Selected");
            alert.show();
        } else {
            foundPolitician = pL.findPoliticans(politicianForUpdateString);
            nameOfPolitician.setText(foundPolitician.getName());
            dateOfBirth.setText(foundPolitician.getDateOfBirth());
            party.setText(foundPolitician.getParty());
            homeCounty.setText(foundPolitician.getHomeCounty());
        }
        return foundPolitician;
    }

    /**
     * Adds an Election
     */

    public void addElection() {
        String electionIdString = electionId.getText();
        String electionTypeString = electionType.getText();
        String electionLocationString = electionLocation.getText();
        String yearDateString = yearDate.getText();
        String seatsString = noOfSeats.getText();

        if ((electionIdString.equals("")) || ((electionTypeString.equals("")) || (electionLocationString.equals("")) || (yearDateString.equals("")) || (seatsString.equals("")))) {
            alert.setContentText("PLEASE ENTER ALL INFORMATION");
            alert.show();
        } else {
            eL.addElection(new Election(electionIdString, electionTypeString, electionLocationString, yearDateString, seatsString));
            electionId.clear();
            electionType.clear();
            electionLocation.clear();
            yearDate.clear();
            noOfSeats.clear();

            listOfElections.setText(eL.listElections());
            listOfElectionforCandidate.setText(eL.listElections());
        }

    }

    /**
     * Deletes an Election
     */

    public void deleteElection() {
        String electionForDelete = electionForDeletion.getText();

        if (electionForDelete.isEmpty()) {
            alert.setContentText("No Election Selected");
            alert.show();
        } else {
            eL.deleteElection(electionForDelete);
            electionForDeletion.clear();

            listOfElections.setText(eL.listElections());
            listOfElectionforCandidate.setText(eL.listElections());
        }
    }

    /**
     * Searches for Election to Update
     */

    public Election seacrhForElectionUpdate() {
        String electionForUpdateString = idForUpdate.getText();
        Election foundElection = null;

        if (electionForUpdateString.isEmpty()) {
            alert.setContentText("No Election Selected");
            alert.show();
        }else {
            foundElection = eL.findElections(electionForUpdateString);
            electionId.setText(foundElection.getElectionID());
            electionType.setText(foundElection.getType());
            electionLocation.setText(foundElection.getLocation());
            yearDate.setText(foundElection.getYearDate());
            noOfSeats.setText(foundElection.getYearDate());
        }
        return foundElection;
    }

    /**
     * Updates an Election
     */

    public void updateElection() {
        String newElectionIdString = electionId.getText();
        String newElectionTypeString = electionType.getText();
        String newElectionLocationString = electionLocation.getText();
        String newYearDateString = yearDate.getText();
        String newSeatsString = noOfSeats.getText();

        seacrhForElectionUpdate().setSeats(newSeatsString);
        seacrhForElectionUpdate().setLocation(newElectionLocationString);
        seacrhForElectionUpdate().setYearDate(newYearDateString);
        seacrhForElectionUpdate().setType(newElectionTypeString);
        seacrhForElectionUpdate().setElectionID(newElectionIdString);

        listOfElections.setText(eL.listElections());
        listOfElectionforCandidate.setText(eL.listElections());

        electionId.clear();
        electionType.clear();
        electionLocation.clear();
        yearDate.clear();
        noOfSeats.clear();
        idForUpdate.clear();
    }

    /**
     * Finds an Election for a Candidate
     */

    public Election findELectionForCandidate() {
        String electionForCandidateString = electionIdForCandidate.getText();
        Election foundElection = null;

        if (electionForCandidateString.isEmpty()) {
            alert.setContentText("No Election Selected");
            alert.show();
        } else {
            foundElection = eL.findElections(electionForCandidateString);
        }
        return foundElection;
    }

    /**
     * Finds a Politician to be a Candidate
     */

    public Politican findPolititcianForCandidate() {
        String politicianForCandidateString = nameOfPoliticianForCandidate.getText();
        Politican foundPolitician = null;

        if (politicianForCandidateString.isEmpty()) {
            alert.setContentText("No politician Selected");
            alert.show();
        } else {
            foundPolitician = pL.findPoliticans(politicianForCandidateString);
        }
        return foundPolitician;
    }

    /**
     * Adds a Politician to an Election
     */

    public void addPoliticianToElection() {
        if((numberOfVotesForCandidate.getText().isEmpty()) || (electionIdForCandidate.getText().isEmpty()) || (nameOfPoliticianForCandidate.getText().isEmpty())) {
            alert.setContentText("Please fill out all information required");
            alert.show();
        }
        else {
            Election electionToAddCandidate = findELectionForCandidate();
            Politican politicanToCandidate = findPolititcianForCandidate();

            String numberOfVotesString = numberOfVotesForCandidate.getText();
            int numberOfVotes = Integer.parseInt(numberOfVotesString);

            eL.findElections(electionToAddCandidate.getElectionID()).getCandidateList().addCandidate((new Candidate(politicanToCandidate.getName(),politicanToCandidate.getDateOfBirth(),politicanToCandidate.getParty(),politicanToCandidate.getHomeCounty(),numberOfVotes)));

            electionIdForCandidate.clear();
            nameOfPoliticianForCandidate.clear();
            numberOfVotesForCandidate.clear();
        }
    }

    /**
     * Removes a Politician from an Election
     */

    public void RemoveAPoliticianFromAnElection() {
        Politican politicanToCandidate = findPolititcianForCandidate();
        Election electionToAddCandidate = findELectionForCandidate();
        if((electionIdForCandidate.getText().isEmpty()) || (nameOfPoliticianForCandidate.getText().isEmpty())) {
            alert.setContentText("Please fill out all information required");
            alert.show();
        }
        else{
            eL.findElections(electionToAddCandidate.getElectionID()).getCandidateList().deleteCandidate(politicanToCandidate.getName());
            electionIdForCandidate.clear();
            nameOfPoliticianForCandidate.clear();
            numberOfVotesForCandidate.clear();
        }
    }

    /**
     * Lists Politicians
     */

    public void listPoliticians() {
        fullList.setText(pL.listPoliticians());

    }

    /**
     * Lists Elections
     */

    public void listElections() {
        fullList.setText(eL.listElections());
    }

    /**
     * Searches for an Election by Election Type
     */

    public void searchElectionByType() {
        String electionTypeString = electionTypeForSearch.getText();
        if (electionTypeString.isEmpty()) {
            alert.setContentText("No Election type Selected");
            alert.show();
        } else {
            fullList.setText(eL.findElectionsByType(electionTypeString));
            electionTypeForSearch.clear();
        }
    }

    /**
     * Search for an Election by Election Year
     */

    public void searchElectionByYear() {
        String electionYearString = electionYearForSearch.getText();
        if (electionYearString.isEmpty()) {
            alert.setContentText("No Election year Selected");
            alert.show();
        } else {
            fullList.setText(eL.findElectionsByYear(electionYearString));
            electionTypeForSearch.clear();
        }
    }

    /**
     * Search for Politicians by the Politicians Party
     */

    public void searchPolitionsbyParty() {
        String politicianPartyString = politionPartyForSearch.getText();
        if(politicianPartyString.isEmpty()){
            alert.setContentText("No Party Selected");
            alert.show();
        }else{
            fullList.setText(pL.findPoliticiansByParty(politicianPartyString));
            politionPartyForSearch.clear();
        }

    }

    /**
     * Search for Politicians by the Politicians Location
     */

    public void searchPolByLocation() {
        String politicianLocationString = locationForSearch.getText();
        if(politicianLocationString.isEmpty()){
            alert.setContentText("No Location Selected");
            alert.show();
        }else{
            fullList.setText(pL.findPoliticiansByLocation(politicianLocationString));
            politionPartyForSearch.clear();
        }
    }

    /**
     * Lists the Candidates of the Election
     */

    public void listCandidatesOfElection() {
        String idForCandidateSearchString = iDforCandidates.getText();
        if(idForCandidateSearchString.isEmpty()){
            alert.setContentText("No ID entered");
            alert.show();
        }else{
            fullList.setText(eL.findElections(idForCandidateSearchString).getCandidateList().listCandidates());
            iDforCandidates.clear();
        }
    }

/*
    public void sortNameInAscendingOrder() {
        String sortedList = "";

        Politican tempNode = null;
        Politican currentNode = pL.head.getContents();
        Politican nextNode = pL.head.next.getContents();

        if(pL.numberOfPoliticans() == 1){
            fullList.setText(pL.listPoliticians());
        }else{
            for(int i = 0; i < pL.numberOfPoliticans();i++){
                if(currentNode.getName().length() < nextNode.getName().length()){
                   tempNode = currentNode;
                   nextNode = currentNode;
                   tempNode = currentNode;
                }
                sortedList += currentNode.toString() + nextNode.toString();
                fullList.setText(sortedList);
            }
        }
    }

    public void sortElectionByVotes() {

    }

*/

    /**
     * XML Save
     */

    @SuppressWarnings("unchecked")
    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Elections Information System.xml"));
        out.writeObject(pL.listPoliticians());
        out.writeObject(eL.listElections());
        out.writeObject(eL.head.getContents().getCandidateList().listCandidates());
        out.close();
    }


    /**
     * XML Load
     */

    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("Elections Information System.xml"));
        is.readObject();
        is.close();
    }


}
