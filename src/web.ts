import { WebPlugin } from '@capacitor/core';

import type { CallPlugin } from './definitions';

export class CallWeb extends WebPlugin implements CallPlugin {
  call(options: { number: string }): Promise<void> {
    window.open(`tel:${options.number}`, '_blank');
    return Promise.resolve();
  }
}
