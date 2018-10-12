package com.fitness.spitfire.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fitness.spitfire.model.Activity;

public class ActivityRepositoryStub {
    private static Map<Long, Activity> activities = new HashMap<>();
    private static Long idIndex = 3L;

    //populate initial wrecks
    static {
        Activity a = new Activity(1L, "C-Core", "C-Core", 45, "Lorand Szabo", new Date());
        activities.put(1L, a);
        Activity b = new Activity(1L, "TRX", "TRX", 70, "Cosmin Rusu", new Date());
        activities.put(2L, b);
        Activity c = new Activity(1L, "Bodycombat", "Bodycombat", 60, "Mona Gheorghiu", new Date());
        activities.put(3L, c);
    }

    public static List<Activity> list() {
        return new ArrayList<Activity>(activities.values());
    }

    public static Activity create(Activity activity) {
        idIndex += idIndex;

        activity.setId(idIndex);
        activities.put(idIndex, activity);

        return activity;
    }

    public static Activity get(Long id) {
        return activities.get(id);
    }

    public static Activity update(Long id, Activity activity) {
        activities.put(id, activity);

        return activity;
    }

    public static Activity delete(Long id) {
        return activities.remove(id);
    }
}
