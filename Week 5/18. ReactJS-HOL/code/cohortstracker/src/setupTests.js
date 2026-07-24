const util = require('util');
const { ReadableStream, WritableStream, TransformStream } = require('stream/web');
const { MessageChannel, MessagePort } = require('worker_threads');

// Attach Node.js Web Text, Stream, and Channel globals to Node's global scope
Object.defineProperties(global, {
  TextEncoder: { value: util.TextEncoder, writable: true },
  TextDecoder: { value: util.TextDecoder, writable: true },
  ReadableStream: { value: ReadableStream, writable: true },
  WritableStream: { value: WritableStream, writable: true },
  TransformStream: { value: TransformStream, writable: true },
  MessageChannel: { value: MessageChannel, writable: true },
  MessagePort: { value: MessagePort, writable: true },
});

// Configure Enzyme
const { configure } = require('enzyme');
const Adapter = require('enzyme-adapter-react-16');

configure({ adapter: new Adapter() });