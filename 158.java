// The API: int read4(char *buf) reads 4 characters at a time from a file.
//
// The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
//
// By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
//
// Note:
// The read function may be called multiple times.
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
 /**
  * @param buf Destination buffer
  * @param n   Maximum number of characters to read
  * @return    The number of characters read
  */
 private int len = 0;
 private char[] buf4 = new char[4];
 private int bindex = 0; // local buf array index
 private int thisCount = 0;
 private boolean eof = false;
 public int read(char[] buf, int n) {
  if (n == 0) return 0;
  int oldlen = len;
  //read from cache
  while (bindex < thisCount && len - oldlen < n) {
   buf[len - oldlen] = buf4[bindex++];
   len++;
  }

  while (len - oldlen < n) {
   if (bindex >= thisCount) { // cache needs data
    if (eof) break; // no data to read any more
    thisCount = read4(buf4);
    bindex = 0;
    if (thisCount < 4) eof = true;
   }
   if (bindex < thisCount) {
    buf[len - oldlen] = buf4[bindex++];
    len++;
   }
   else break;
  }

  return len - oldlen;
 }
}
