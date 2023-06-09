import java.util.*;

class Solution {
    Set<Set<String>> set = new HashSet<>();

	public int solution(String[] user_ids, String[] banned_ids) {
		int answer = 0;
		Set<String> combSet = new HashSet<>();
		dfs(combSet, 0, user_ids, banned_ids);
		answer = set.size();
		return answer;
	}

	public void dfs(Set<String> combSet, int depth, String[] user_ids, String[] banned_ids) {
		if (depth == banned_ids.length) {
			set.add(combSet);
			return;
		}

		String banned_id = banned_ids[depth];

		for (int i = 0; i < user_ids.length; i++) {
			String user_id = user_ids[i];
			if (check(user_id, banned_id) && !combSet.contains(user_id)) {
				combSet.add(user_id);

				Set<String> copySet = new HashSet<>();
				copySet.addAll(combSet);

				dfs(copySet, depth + 1, user_ids, banned_ids);

				combSet.remove(user_id);
			}
		}
	}

	public boolean check(String user_id, String banned_id) {
		String regex = banned_id.replace("*", ".");
		return user_id.matches(regex);
	}
}