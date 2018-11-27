package com.hmproductions.multiplayertutorial.dagger;

import com.hmproductions.multiplayertutorial.MainActivity;
import dagger.Component;

@TutorialApplicationScope
@Component (modules = {  })
public interface TutorialApplicationComponent {
    void inject(MainActivity mainActivity);
}
