package org.baltimorecityschools.gamel;

import android.content.Context;
import android.content.Intent;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationBarLogic {

    public static void setupNavigationBar(final Context context, BottomNavigationView bottomNavigationView) {
        bottomNavigationView.setOnItemSelectedListener(item -> {

            int itemId = item.getItemId();

            if(itemId == R.id.settingsNavigationButton) {
                if (!(context instanceof OnboardingActivity)) {
                    Intent intent = new Intent(context, OnboardingActivity.class);
                    intent.putExtra("onboarding_edit", true);
                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    context.startActivity(intent);

                }
                return true;
            }else if(itemId == R.id.homeNavigationButton) {
                if (!(context instanceof HomeActivity)) {
                    Intent intent = new Intent(context, HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    context.startActivity(intent);

                }
                return true;
            }else if (itemId == R.id.searchNavigationButton) {
                if (!(context instanceof SearchActivity)) {
                    Intent intent = new Intent(context, SearchActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    context.startActivity(intent);
                }
                return true;
            }else if (itemId == R.id.allgamesNavigationButton) {
                if (!(context instanceof AllGamesActivity)) {
                    Intent intent = new Intent(context, AllGamesActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    context.startActivity(intent);
                }
                return true;

            }
            return false;

        });


    }
}
