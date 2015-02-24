#define A(i, j) A[(i)*w + (j)]
int fractal_newton_para(double x1, double x2, double y1, double y2,
                   int w, int h, Byte *A, double tol, int maxiter)
{
    double t = omp_get_wtime();
    
  int i, j, ni, max;
  Complejo z0;
  double ix, iy;
 
  ix = (x2-x1)/(w-1);
  iy = (y2-y1)/(h-1);
  max = 0;
   
  #pragma omp parallel for private(j,z0,ni) schedule(runtime)
  for (i = 0; i < h; i++) {
    z0.b = y1 + iy*i;   
    for (j = 0; j < w; j++) {
      z0.a = x1 + ix*j;
      ni = newton(z0, tol, maxiter);
             
      if (ni > max) {
        #pragma omp critical
        if (ni > max) {max = ni;}
      }      
       
      A(i, j) = ni;
    }
  }
  printf("Ha tardat: %f segons\n",(omp_get_wtime()-t));
  return max;
}
