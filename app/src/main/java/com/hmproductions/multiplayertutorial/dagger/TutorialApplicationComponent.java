package com.hmproductions.multiplayertutorial.dagger;

import com.hmproductions.multiplayertutorial.MainActivity;
import dagger.Component;

@TutorialApplicationScope
@Component (modules = {ContextModule.class, StubModule.class, ChannelModule.class })
public interface TutorialApplicationComponent {
    void inject(MainActivity mainActivity);
}
