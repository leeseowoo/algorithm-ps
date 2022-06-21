import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        int skillLng = skill.length();
        int treesLng = skill_trees.length;
        
        for(int i = 0; i < skillLng; i++) {
            map.put(skill.charAt(i), i);
        }
        
        for(int i = 0; i < treesLng; i++) {
            if(learnSkills(skill_trees[i], map)) {
                answer += 1;
            }
        }
        
        return answer;
    }
    
    boolean learnSkills(String skillTree, Map<Character, Integer> map) {
        int recent = -1;
        int lng = skillTree.length();
        
        for(int i = 0; i < lng; i++) {
            char currentTreeSkill = skillTree.charAt(i);

            if(map.containsKey(currentTreeSkill)) {
                if(recent == (map.get(currentTreeSkill) - 1)) {
                    recent += 1;
                } else {
                    return false;
                }   
            }
        }
        
        return true;
    }
}