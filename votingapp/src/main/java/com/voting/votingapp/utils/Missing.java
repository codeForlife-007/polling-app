package com.voting.votingapp.utils;

import java.util.Collection;

public class Missing {
  public static boolean string(String value) { return value.isEmpty(); }

  public static boolean list(Collection<?> value) { return value == null || value.isEmpty(); }
}
