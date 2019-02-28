package com.google.zxing.pdf417.encoder;

import com.alipay.sdk.data.C0116f;
import com.autonavi.amap.mapcore.VTMCDataCache;
import com.google.zxing.WriterException;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;

final class PDF417ErrorCorrection {
    private static final int[][] EC_COEFFICIENTS = new int[][]{new int[]{27, 917}, new int[]{522, 568, 723, 809}, new int[]{237, ErrorCode.ERROR_CANLOADX5_RETURN_NULL, 436, 284, 646, 653, 428, 379}, new int[]{274, 562, 232, 755, 599, 524, 801, 132, 295, 116, 442, 428, 295, 42, 176, 65}, new int[]{361, 575, 922, 525, 176, 586, 640, ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01, 536, 742, 677, 742, 687, 284, 193, 517, 273, 494, 263, 147, 593, 800, 571, ErrorCode.ERROR_SDKENGINE_ISCOMPATIBLE, 803, 133, 231, 390, 685, ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 63, 410}, new int[]{539, 422, 6, 93, 862, 771, 453, ErrorCode.FILE_DELETED, 610, 287, ErrorCode.UNKNOWN_ERROR, 505, 733, 877, 381, 612, 723, 476, 462, 172, 430, 609, 858, 822, 543, 376, 511, ErrorCode.INFO_CODE_BASE, 672, 762, 283, 184, 440, 35, 519, 31, 460, 594, 225, 535, 517, 352, 605, 158, 651, ErrorCode.EXCEED_UNZIP_RETRY_NUM, 488, 502, 648, 733, 717, 83, ErrorCode.INFO_DISABLE_X5, 97, 280, 771, 840, 629, 4, 381, 843, 623, 264, 543}, new int[]{521, ErrorCode.THROWABLE_LOAD_TBS, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, ErrorCode.INFO_CODE_BASE, 925, 749, 415, 822, 93, ErrorCode.INCR_UPDATE_FAIL, ErrorCode.EXCEED_DEXOPT_RETRY_NUM, 928, 244, 583, 620, 246, 148, 447, 631, 292, 908, 490, 704, 516, 258, 457, 907, 594, 723, 674, 292, 272, 96, 684, 432, 686, 606, 860, 569, 193, ErrorCode.RENAME_EXCEPTION, 129, 186, 236, 287, 192, 775, 278, 173, 40, 379, 712, 463, 646, 776, 171, 491, 297, 763, 156, 732, 95, 270, 447, 90, 507, 48, 228, 821, 808, 898, 784, 663, 627, 378, 382, 262, 380, 602, 754, 336, 89, 614, 87, 432, 670, 616, 157, 374, 242, 726, 600, 269, 375, 898, 845, 454, 354, 130, 814, 587, 804, 34, ErrorCode.EXCEED_COPY_RETRY_NUM, ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 539, 297, 827, 865, 37, 517, 834, ErrorCode.ERROR_QBSDK_INIT, 550, 86, 801, 4, ErrorCode.VERIFY_ERROR, 539}, new int[]{524, 894, 75, 766, 882, 857, 74, ErrorCode.APK_INVALID, 82, 586, 708, 250, 905, 786, 138, 720, 858, 194, ErrorCode.ERROR_TBSCORE_DEXOPT_DIR, 913, 275, 190, 375, 850, 438, 733, 194, 280, ErrorCode.EXCEED_UNZIP_RETRY_NUM, 280, 828, 757, 710, 814, 919, 89, 68, 569, 11, ErrorCode.APK_INVALID, 796, 605, 540, 913, 801, 700, 799, 137, 439, 418, 592, 668, 353, 859, 370, 694, ErrorCode.THROWABLE_INITX5CORE, 240, ErrorCode.INCR_UPDATE_ERROR, 257, 284, 549, ErrorCode.DEXOPT_EXCEPTION, 884, ErrorCode.ERROR_QBSDK_INIT, 70, ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, 793, 490, 274, 877, 162, 749, 812, 684, 461, 334, 376, 849, 521, ErrorCode.ERROR_CANLOADX5_RETURN_FALSE, 291, 803, 712, 19, 358, 399, 908, 103, 511, 51, 8, 517, 225, 289, 470, 637, 731, 66, WebView.NORMAL_MODE_ALPHA, 917, 269, 463, 830, 730, 433, 848, 585, 136, 538, 906, 90, 2, 290, 743, 199, 655, 903, ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, 49, 802, 580, 355, 588, 188, 462, 10, 134, 628, ErrorCode.ERROR_SDKENGINE_ISCOMPATIBLE, 479, 130, 739, 71, 263, ErrorCode.ERROR_QBSDK_INIT_ISSUPPORT, 374, 601, 192, 605, 142, 673, 687, 234, 722, 384, 177, 752, 607, 640, 455, 193, 689, 707, 805, 641, 48, 60, 732, 621, 895, 544, 261, 852, 655, ErrorCode.ERROR_LESS_THAN_MIN_SUPPORT_VER, 697, 755, 756, 60, 231, 773, 434, 421, 726, 528, C0116f.f324b, 118, 49, 795, 32, 144, VTMCDataCache.MAXSIZE, 238, 836, 394, 280, 566, ErrorCode.ERROR_QBSDK_INIT_CANLOADX5, 9, 647, 550, 73, 914, 342, 126, 32, 681, 331, 792, 620, 60, 609, 441, 180, 791, 893, 754, 605, 383, 228, 749, 760, ErrorCode.COPY_SRCDIR_ERROR, 54, 297, 134, 54, 834, 299, 922, 191, 910, 532, 609, 829, 189, 20, 167, 29, 872, 449, 83, ErrorCode.INFO_FORCE_SYSTEM_WEBVIEW_OUTER, 41, 656, 505, 579, 481, 173, ErrorCode.INFO_DISABLE_X5, 251, 688, 95, 497, 555, 642, 543, ErrorCode.ERROR_CANLOADX5_RETURN_FALSE, 159, 924, 558, 648, 55, 497, 10}, new int[]{352, 77, 373, 504, 35, 599, 428, ErrorCode.UNZIP_OTHER_ERROR, 409, 574, 118, 498, 285, 380, 350, 492, 197, 265, 920, 155, 914, 299, 229, 643, 294, 871, ErrorCode.THROWABLE_QBSDK_INIT, 88, 87, 193, 352, 781, 846, 75, ErrorCode.TEST_THROWABLE_ISNOT_NULL, 520, 435, 543, ErrorCode.APK_VERSION_ERROR, 666, 249, 346, 781, 621, 640, 268, 794, 534, 539, 781, 408, 390, 644, 102, 476, 499, 290, 632, 545, 37, 858, 916, 552, 41, 542, 289, 122, 272, 383, 800, 485, 98, 752, 472, 761, ErrorCode.UNKNOWN_ERROR, 784, 860, 658, 741, 290, ErrorCode.APK_INVALID, 681, 407, 855, 85, 99, 62, 482, 180, 20, 297, 451, 593, 913, 142, 808, 684, 287, 536, 561, 76, 653, 899, 729, 567, 744, 390, 513, 192, 516, 258, 240, 518, 794, 395, 768, 848, 51, 610, 384, 168, 190, 826, ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT, 596, 786, ErrorCode.ERROR_UNMATCH_TBSCORE_VER, 570, 381, 415, 641, 156, 237, 151, 429, 531, ErrorCode.UNZIP_OTHER_ERROR, 676, 710, 89, 168, ErrorCode.ERROR_HOST_UNAVAILABLE, ErrorCode.INFO_FORCE_SYSTEM_WEBVIEW_OUTER, 40, 708, 575, 162, 864, 229, 65, 861, 841, 512, 164, 477, ErrorCode.INCRUPDATE_INSTALL_SUCCESS, 92, 358, 785, 288, 357, 850, 836, 827, 736, 707, 94, 8, 494, 114, 521, 2, 499, 851, 543, 152, 729, 771, 95, 248, 361, 578, ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_03, 856, 797, 289, 51, 684, 466, 533, 820, 669, 45, 902, 452, 167, 342, 244, 173, 35, 463, 651, 51, 699, 591, 452, 578, 37, 124, 298, 332, 552, 43, 427, 119, 662, 777, 475, 850, 764, 364, 578, 911, 283, 711, 472, 420, 245, 288, 594, 394, 511, ErrorCode.TEST_THROWABLE_ISNOT_NULL, 589, 777, 699, 688, 43, 408, 842, 383, 721, 521, 560, 644, 714, 559, 62, 145, 873, 663, 713, 159, 672, 729, 624, 59, 193, 417, 158, ErrorCode.DEXOPT_EXCEPTION, 563, 564, 343, 693, ErrorCode.FILE_RENAME_ERROR, 608, 563, 365, 181, 772, 677, ErrorCode.THROWABLE_LOAD_TBS, 248, 353, 708, 410, 579, 870, 617, 841, 632, 860, 289, 536, 35, 777, 618, 586, 424, 833, 77, 597, 346, 269, 757, 632, 695, 751, 331, 247, 184, 45, 787, 680, 18, 66, 407, 369, 54, 492, 228, 613, 830, 922, 437, 519, 644, 905, 789, 420, ErrorCode.EXCEPTION_QBSDK_INIT, 441, ErrorCode.UNZIP_OTHER_ERROR, ErrorCode.ERROR_CODE_LOAD_BASE, 892, 827, 141, 537, 381, 662, 513, 56, 252, 341, 242, 797, 838, 837, 720, 224, ErrorCode.ERROR_CANLOADX5_RETURN_FALSE, 631, 61, 87, 560, ErrorCode.THROWABLE_LOAD_TBS, 756, 665, 397, 808, 851, ErrorCode.ERROR_LESS_THAN_MIN_SUPPORT_VER, 473, 795, 378, 31, 647, 915, 459, 806, 590, 731, 425, ErrorCode.INCR_UPDATE_ERROR, 548, 249, ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01, 881, 699, 535, 673, 782, ErrorCode.ROM_NOT_ENOUGH, 815, 905, ErrorCode.ERROR_UNMATCH_TBSCORE_VER, 843, 922, 281, 73, 469, 791, 660, 162, 498, ErrorCode.ERROR_CANLOADX5_RETURN_NULL, 155, 422, 907, 817, 187, 62, 16, 425, 535, 336, 286, 437, 375, 273, 610, 296, 183, 923, 116, 667, 751, 353, 62, 366, 691, 379, 687, 842, 37, 357, 720, 742, ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 5, 39, 923, ErrorCode.ERROR_TBSCORE_DEXOPT_DIR, 424, 242, 749, ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01, 54, 669, ErrorCode.ERROR_QBSDK_INIT_END, 342, 299, 534, ErrorCode.DISK_FULL, 667, 488, 640, 672, 576, 540, ErrorCode.ERROR_QBSDK_INIT_END, 486, 721, 610, 46, 656, 447, 171, 616, 464, 190, 531, 297, ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01, 762, 752, 533, 175, 134, 14, 381, 433, 717, 45, ErrorCode.NETWORK_NOT_WIFI_ERROR, 20, 596, 284, 736, 138, 646, 411, 877, 669, 141, 919, 45, 780, 407, 164, 332, 899, 165, 726, 600, ErrorCode.THROWABLE_INITX5CORE, 498, 655, 357, 752, 768, 223, 849, 647, 63, ErrorCode.THROWABLE_LOAD_TBS, 863, 251, 366, ErrorCode.ERROR_HOST_UNAVAILABLE, 282, 738, 675, 410, 389, 244, 31, 121, ErrorCode.ERROR_UNMATCH_TBSCORE_VER, 263}};

    private PDF417ErrorCorrection() {
    }

    static int getErrorCorrectionCodewordCount(int errorCorrectionLevel) {
        if (errorCorrectionLevel >= 0 && errorCorrectionLevel <= 8) {
            return 1 << (errorCorrectionLevel + 1);
        }
        throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
    }

    static int getRecommendedMinimumErrorCorrectionLevel(int n) throws WriterException {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        } else if (n <= 40) {
            return 2;
        } else {
            if (n <= 160) {
                return 3;
            }
            if (n <= ErrorCode.ERROR_SDKENGINE_ISCOMPATIBLE) {
                return 4;
            }
            if (n <= 863) {
                return 5;
            }
            throw new WriterException("No recommendation possible");
        }
    }

    static String generateErrorCorrection(CharSequence dataCodewords, int errorCorrectionLevel) {
        int j;
        int k = getErrorCorrectionCodewordCount(errorCorrectionLevel);
        char[] e = new char[k];
        int sld = dataCodewords.length();
        for (int i = 0; i < sld; i++) {
            int t1 = (dataCodewords.charAt(i) + e[e.length - 1]) % 929;
            for (j = k - 1; j >= 1; j--) {
                e[j] = (char) ((e[j - 1] + (929 - ((EC_COEFFICIENTS[errorCorrectionLevel][j] * t1) % 929))) % 929);
            }
            e[0] = (char) ((929 - ((EC_COEFFICIENTS[errorCorrectionLevel][0] * t1) % 929)) % 929);
        }
        StringBuilder sb = new StringBuilder(k);
        for (j = k - 1; j >= 0; j--) {
            if (e[j] != '\u0000') {
                e[j] = (char) (929 - e[j]);
            }
            sb.append(e[j]);
        }
        return sb.toString();
    }
}
