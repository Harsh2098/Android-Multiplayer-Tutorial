package com.hmproductions.multiplayertutorial.dagger;

import javax.inject.Scope;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface TutorialApplicationScope {
}
