export interface CallPlugin {
  /**
   * Open the dialer with the given number
   */
  call(options: { number: string }): Promise<void>;
}
