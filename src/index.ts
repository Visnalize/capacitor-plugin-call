import { registerPlugin } from '@capacitor/core';

import type { CallPlugin } from './definitions';

const Call = registerPlugin<CallPlugin>('Call', {
  web: () => import('./web').then(m => new m.CallWeb()),
});

export * from './definitions';
export { Call };
