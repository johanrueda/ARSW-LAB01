package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

import java.util.LinkedList;

public class ThreadSearch extends Thread{

    String ip;
    int inicio;
    int finall;
    LinkedList<Integer> blackListOcurrences;
    HostBlacklistsDataSourceFacade skds;
    int checkedListCount=0;

    public ThreadSearch(String ip, int inicio, int finall){
        this.ip=ip;
        this.inicio=inicio;
        this.finall=finall;
        blackListOcurrences = new LinkedList<>();
        skds = HostBlacklistsDataSourceFacade.getInstance();
    }

    public void run(){
        for(int x=inicio;x<finall;x++){
            if(skds.isInBlackListServer(x,ip)){
                blackListOcurrences.add(x);
                checkedListCount +=1;
            }

        }
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFinall() {
        return finall;
    }

    public void setFinall(int finall) {
        this.finall = finall;
    }

    public LinkedList<Integer> getBlackListOcurrences() {
        return blackListOcurrences;
    }

    public void setBlackListOcurrences(LinkedList<Integer> blackListOcurrences) {
        this.blackListOcurrences = blackListOcurrences;
    }

    public HostBlacklistsDataSourceFacade getSkds() {
        return skds;
    }

    public void setSkds(HostBlacklistsDataSourceFacade skds) {
        this.skds = skds;
    }

    public int getCheckedListCount() {
        return checkedListCount;
    }

    public void setCheckedListCount(int checkedListCount) {
        this.checkedListCount = checkedListCount;
    }
}
