import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class FileManagerTest {

    @Test
    void testVoidMethodThrowsException() {

        FileService mockService = mock(FileService.class);

        doThrow(new RuntimeException("Delete failed"))
                .when(mockService)
                .deleteFile();

        FileManager manager = new FileManager(mockService);

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.removeFile()
        );

        verify(mockService).deleteFile();
    }
}
