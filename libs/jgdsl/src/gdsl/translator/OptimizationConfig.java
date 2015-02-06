package gdsl.translator;

public class OptimizationConfig {
  private final int config;

  /**
   * Get the Gdsl config; this integer is used to describe
   * the optimization configuration on the Gdsl side.
   * 
   * @return the internal Gdsl config
   */
  public int getConfig () {
    return config;
  }

  public OptimizationConfig (int config) {
    this.config = config;
  }

  public OptimizationConfig and (OptimizationOptions option) {
    return new OptimizationConfig(config | option.getFlag());
  }

  public OptimizationConfig andNot (OptimizationOptions option) {
    return new OptimizationConfig(config & ~option.getFlag());
  }

}
