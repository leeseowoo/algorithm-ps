import java.util.Arrays;

class Solution {
    
    int ticketsNum;
    String[] answer;
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        ticketsNum = tickets.length;
        answer = new String[ticketsNum + 1];
        visited = new boolean[ticketsNum];
        
        // 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 먼저 방문하기 위함
        Arrays.sort(tickets, (o1, o2) -> {
            if(o1[0].contentEquals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            } else {
                return o1[0].compareTo(o2[0]);
            }
        });
        
        travel("ICN", 1, tickets);
        
        return answer;
    }
    
    boolean travel(String airport, int visit, String[][] tickets) {
        answer[visit - 1] = airport;
        
        if(ticketsNum + 1 == visit) {
            return true;
        }
        
        for(int i = 0; i < ticketsNum; i++) {
            if(airport.equals(tickets[i][0])) {
                if(!visited[i]) {
                    visited[i] = true;

                    if(travel(tickets[i][1], visit + 1, tickets)) {
                        return true;
                    } else {
                        visited[i] = false;
                    }
                }
            }
        }
        
        return false;
    }
}